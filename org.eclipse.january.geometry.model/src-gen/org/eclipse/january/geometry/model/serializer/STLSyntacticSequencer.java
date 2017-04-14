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
package org.eclipse.january.geometry.model.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.january.geometry.model.services.STLGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class STLSyntacticSequencer extends AbstractSyntacticSequencer {

	protected STLGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Shape_Impl_EStringParserRuleCall_7_q;
	protected AbstractElementAlias match_Shape_Impl_WSTerminalRuleCall_5_a;
	protected AbstractElementAlias match_Shape_Impl___ANY_OTHERTerminalRuleCall_3_4_or_DOUBLETerminalRuleCall_3_3_or_IDTerminalRuleCall_3_0_or_STRINGTerminalRuleCall_3_2_or_WSTerminalRuleCall_3_1__a;
	protected AbstractElementAlias match_Shape_Impl___ANY_OTHERTerminalRuleCall_8_4_or_DOUBLETerminalRuleCall_8_3_or_IDTerminalRuleCall_8_0_or_STRINGTerminalRuleCall_8_2_or_WSTerminalRuleCall_8_1__a;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (STLGrammarAccess) access;
		match_Shape_Impl_EStringParserRuleCall_7_q = new TokenAlias(false, true, grammarAccess.getShape_ImplAccess().getEStringParserRuleCall_7());
		match_Shape_Impl_WSTerminalRuleCall_5_a = new TokenAlias(true, true, grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_5());
		match_Shape_Impl___ANY_OTHERTerminalRuleCall_3_4_or_DOUBLETerminalRuleCall_3_3_or_IDTerminalRuleCall_3_0_or_STRINGTerminalRuleCall_3_2_or_WSTerminalRuleCall_3_1__a = new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getShape_ImplAccess().getANY_OTHERTerminalRuleCall_3_4()), new TokenAlias(false, false, grammarAccess.getShape_ImplAccess().getDOUBLETerminalRuleCall_3_3()), new TokenAlias(false, false, grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_3_0()), new TokenAlias(false, false, grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_3_2()), new TokenAlias(false, false, grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_3_1()));
		match_Shape_Impl___ANY_OTHERTerminalRuleCall_8_4_or_DOUBLETerminalRuleCall_8_3_or_IDTerminalRuleCall_8_0_or_STRINGTerminalRuleCall_8_2_or_WSTerminalRuleCall_8_1__a = new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getShape_ImplAccess().getANY_OTHERTerminalRuleCall_8_4()), new TokenAlias(false, false, grammarAccess.getShape_ImplAccess().getDOUBLETerminalRuleCall_8_3()), new TokenAlias(false, false, grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_8_0()), new TokenAlias(false, false, grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_8_2()), new TokenAlias(false, false, grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_8_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getANY_OTHERRule())
			return getANY_OTHERToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getDOUBLERule())
			return getDOUBLEToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEStringRule())
			return getEStringToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getIDRule())
			return getIDToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getSTRINGRule())
			return getSTRINGToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getWSRule())
			return getWSToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal ANY_OTHER: .;
	 */
	protected String getANY_OTHERToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * terminal DOUBLE returns ecore::EDouble:
	 * 	(('-'|'+')? INT? '.' INT (('E'|'e') ('-'|'+')? INT)?) | INT;
	 */
	protected String getDOUBLEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ".";
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
	
	/**
	 * terminal ID  		: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	 */
	protected String getIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * terminal STRING	: 
	 * 			'"' ( '\\' .  | !('\\'|'"') )* '"' |
	 * 			"'" ( '\\' .  | !('\\'|"'") )* "'"
	 * 		;
	 */
	protected String getSTRINGToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\"\"";
	}
	
	/**
	 * terminal WS			: (' '|'\t'|'\r'|'\n')+;
	 */
	protected String getWSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return " ";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_Shape_Impl_EStringParserRuleCall_7_q.equals(syntax))
				emit_Shape_Impl_EStringParserRuleCall_7_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Shape_Impl_WSTerminalRuleCall_5_a.equals(syntax))
				emit_Shape_Impl_WSTerminalRuleCall_5_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Shape_Impl___ANY_OTHERTerminalRuleCall_3_4_or_DOUBLETerminalRuleCall_3_3_or_IDTerminalRuleCall_3_0_or_STRINGTerminalRuleCall_3_2_or_WSTerminalRuleCall_3_1__a.equals(syntax))
				emit_Shape_Impl___ANY_OTHERTerminalRuleCall_3_4_or_DOUBLETerminalRuleCall_3_3_or_IDTerminalRuleCall_3_0_or_STRINGTerminalRuleCall_3_2_or_WSTerminalRuleCall_3_1__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Shape_Impl___ANY_OTHERTerminalRuleCall_8_4_or_DOUBLETerminalRuleCall_8_3_or_IDTerminalRuleCall_8_0_or_STRINGTerminalRuleCall_8_2_or_WSTerminalRuleCall_8_1__a.equals(syntax))
				emit_Shape_Impl___ANY_OTHERTerminalRuleCall_8_4_or_DOUBLETerminalRuleCall_8_3_or_IDTerminalRuleCall_8_0_or_STRINGTerminalRuleCall_8_2_or_WSTerminalRuleCall_8_1__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     EString?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'solid' (ID | WS | STRING | DOUBLE | ANY_OTHER)* WS* 'endsolid' (ambiguity) (ID | WS | STRING | DOUBLE | ANY_OTHER)* (rule start)
	 *     name=EString (ID | WS | STRING | DOUBLE | ANY_OTHER)* WS* 'endsolid' (ambiguity) (ID | WS | STRING | DOUBLE | ANY_OTHER)* (rule end)
	 *     triangles+=Triangle WS* 'endsolid' (ambiguity) (ID | WS | STRING | DOUBLE | ANY_OTHER)* (rule end)
	 */
	protected void emit_Shape_Impl_EStringParserRuleCall_7_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     WS*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'solid' (ID | WS | STRING | DOUBLE | ANY_OTHER)* (ambiguity) 'endsolid' EString? (ID | WS | STRING | DOUBLE | ANY_OTHER)* (rule start)
	 *     name=EString (ID | WS | STRING | DOUBLE | ANY_OTHER)* (ambiguity) 'endsolid' EString? (ID | WS | STRING | DOUBLE | ANY_OTHER)* (rule end)
	 *     triangles+=Triangle (ambiguity) 'endsolid' EString? (ID | WS | STRING | DOUBLE | ANY_OTHER)* (rule end)
	 */
	protected void emit_Shape_Impl_WSTerminalRuleCall_5_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (ID | WS | STRING | DOUBLE | ANY_OTHER)*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'solid' (ambiguity) WS* 'endsolid' EString? (ID | WS | STRING | DOUBLE | ANY_OTHER)* (rule start)
	 *     (rule start) 'solid' (ambiguity) triangles+=Triangle
	 *     name=EString (ambiguity) WS* 'endsolid' EString? (ID | WS | STRING | DOUBLE | ANY_OTHER)* (rule end)
	 *     name=EString (ambiguity) triangles+=Triangle
	 */
	protected void emit_Shape_Impl___ANY_OTHERTerminalRuleCall_3_4_or_DOUBLETerminalRuleCall_3_3_or_IDTerminalRuleCall_3_0_or_STRINGTerminalRuleCall_3_2_or_WSTerminalRuleCall_3_1__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (ID | WS | STRING | DOUBLE | ANY_OTHER)*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'solid' (ID | WS | STRING | DOUBLE | ANY_OTHER)* WS* 'endsolid' EString? (ambiguity) (rule start)
	 *     name=EString (ID | WS | STRING | DOUBLE | ANY_OTHER)* WS* 'endsolid' EString? (ambiguity) (rule end)
	 *     triangles+=Triangle WS* 'endsolid' EString? (ambiguity) (rule end)
	 */
	protected void emit_Shape_Impl___ANY_OTHERTerminalRuleCall_8_4_or_DOUBLETerminalRuleCall_8_3_or_IDTerminalRuleCall_8_0_or_STRINGTerminalRuleCall_8_2_or_WSTerminalRuleCall_8_1__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
