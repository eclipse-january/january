/*******************************************************************************
 * Copyright (c) 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - 
 *   Kasper Gammeltoft
 *******************************************************************************/
package xtext.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import xtext.services.STLGrammarAccess;

@SuppressWarnings("all")
public class STLSyntacticSequencer extends AbstractSyntacticSequencer {

	protected STLGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Geometry_Control000aKeyword_4_q;
	protected AbstractElementAlias match_Geometry_EStringParserRuleCall_6_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (STLGrammarAccess) access;
		match_Geometry_Control000aKeyword_4_q = new TokenAlias(false, true, grammarAccess.getGeometryAccess().getControl000aKeyword_4());
		match_Geometry_EStringParserRuleCall_6_q = new TokenAlias(false, true, grammarAccess.getGeometryAccess().getEStringParserRuleCall_6());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getEStringRule())
			return getEStringToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * EString returns ecore::EString:
	 * 	STRING | ID;
	 */
	protected String getEStringToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\"\"";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_Geometry_Control000aKeyword_4_q.equals(syntax))
				emit_Geometry_Control000aKeyword_4_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Geometry_EStringParserRuleCall_6_q.equals(syntax))
				emit_Geometry_EStringParserRuleCall_6_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '
	  *     '?
	 *
	 * This ambiguous syntax occurs at:
	 *     nodes+=Shape_Impl (ambiguity) 'endsolid' EString? (rule end)
	 */
	protected void emit_Geometry_Control000aKeyword_4_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     EString?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         nodes+=Shape_Impl 
	 *         '
	 *         '? 
	 *         'endsolid' 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 */
	protected void emit_Geometry_EStringParserRuleCall_6_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
