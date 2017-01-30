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
package dsl.ide.contentassist.antlr;

import com.google.inject.Inject;

import dsl.ide.contentassist.antlr.internal.InternalSTLParser;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.antlr.runtime.RecognitionException;
import org.eclipse.january.geometry.model.dsl.services.STLGrammarAccess;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

public class STLParser extends AbstractContentAssistParser {

	@Inject
	private STLGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalSTLParser createParser() {
		InternalSTLParser result = new InternalSTLParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getShape_ImplAccess().getAlternatives_3(), "rule__Shape_Impl__Alternatives_3");
					put(grammarAccess.getShape_ImplAccess().getAlternatives_8(), "rule__Shape_Impl__Alternatives_8");
					put(grammarAccess.getEStringAccess().getAlternatives(), "rule__EString__Alternatives");
					put(grammarAccess.getGeometryAccess().getGroup(), "rule__Geometry__Group__0");
					put(grammarAccess.getShape_ImplAccess().getGroup(), "rule__Shape_Impl__Group__0");
					put(grammarAccess.getTriangleAccess().getGroup(), "rule__Triangle__Group__0");
					put(grammarAccess.getTriangleAccess().getGroup_2(), "rule__Triangle__Group_2__0");
					put(grammarAccess.getTriangleAccess().getGroup_5(), "rule__Triangle__Group_5__0");
					put(grammarAccess.getVertexAccess().getGroup(), "rule__Vertex__Group__0");
					put(grammarAccess.getGeometryAccess().getNodesAssignment_1(), "rule__Geometry__NodesAssignment_1");
					put(grammarAccess.getShape_ImplAccess().getNameAssignment_2(), "rule__Shape_Impl__NameAssignment_2");
					put(grammarAccess.getShape_ImplAccess().getTrianglesAssignment_4(), "rule__Shape_Impl__TrianglesAssignment_4");
					put(grammarAccess.getTriangleAccess().getNormalAssignment_2_1(), "rule__Triangle__NormalAssignment_2_1");
					put(grammarAccess.getTriangleAccess().getVerticesAssignment_5_1(), "rule__Triangle__VerticesAssignment_5_1");
					put(grammarAccess.getVertexAccess().getXAssignment_1(), "rule__Vertex__XAssignment_1");
					put(grammarAccess.getVertexAccess().getYAssignment_2(), "rule__Vertex__YAssignment_2");
					put(grammarAccess.getVertexAccess().getZAssignment_3(), "rule__Vertex__ZAssignment_3");
				}
			};
		}
		return nameMappings.get(element);
	}

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			InternalSTLParser typedParser = (InternalSTLParser) parser;
			typedParser.entryRuleGeometry();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public STLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(STLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
