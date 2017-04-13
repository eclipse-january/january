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
package org.eclipse.january.geometry.model.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class STLGrammarAccess extends AbstractGrammarElementFinder {
	
	public class GeometryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.january.geometry.model.STL.Geometry");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cGeometryAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNodesAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNodesShape_ImplParserRuleCall_1_0 = (RuleCall)cNodesAssignment_1.eContents().get(0);
		
		//Geometry:
		//	{Geometry} nodes+=Shape_Impl*;
		@Override public ParserRule getRule() { return rule; }
		
		//{Geometry} nodes+=Shape_Impl*
		public Group getGroup() { return cGroup; }
		
		//{Geometry}
		public Action getGeometryAction_0() { return cGeometryAction_0; }
		
		//nodes+=Shape_Impl*
		public Assignment getNodesAssignment_1() { return cNodesAssignment_1; }
		
		//Shape_Impl
		public RuleCall getNodesShape_ImplParserRuleCall_1_0() { return cNodesShape_ImplParserRuleCall_1_0; }
	}
	public class Shape_ImplElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.january.geometry.model.STL.Shape_Impl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cShapeAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cSolidKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameEStringParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final RuleCall cIDTerminalRuleCall_3_0 = (RuleCall)cAlternatives_3.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_3_1 = (RuleCall)cAlternatives_3.eContents().get(1);
		private final RuleCall cSTRINGTerminalRuleCall_3_2 = (RuleCall)cAlternatives_3.eContents().get(2);
		private final RuleCall cDOUBLETerminalRuleCall_3_3 = (RuleCall)cAlternatives_3.eContents().get(3);
		private final RuleCall cANY_OTHERTerminalRuleCall_3_4 = (RuleCall)cAlternatives_3.eContents().get(4);
		private final Assignment cTrianglesAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cTrianglesTriangleParserRuleCall_4_0 = (RuleCall)cTrianglesAssignment_4.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_5 = (RuleCall)cGroup.eContents().get(5);
		private final Keyword cEndsolidKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final RuleCall cEStringParserRuleCall_7 = (RuleCall)cGroup.eContents().get(7);
		private final Alternatives cAlternatives_8 = (Alternatives)cGroup.eContents().get(8);
		private final RuleCall cIDTerminalRuleCall_8_0 = (RuleCall)cAlternatives_8.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_8_1 = (RuleCall)cAlternatives_8.eContents().get(1);
		private final RuleCall cSTRINGTerminalRuleCall_8_2 = (RuleCall)cAlternatives_8.eContents().get(2);
		private final RuleCall cDOUBLETerminalRuleCall_8_3 = (RuleCall)cAlternatives_8.eContents().get(3);
		private final RuleCall cANY_OTHERTerminalRuleCall_8_4 = (RuleCall)cAlternatives_8.eContents().get(4);
		
		//Shape_Impl Shape:
		//	{Shape}
		//	'solid'
		//	name=EString? (ID | WS | STRING | DOUBLE | ANY_OTHER)*
		//	triangles+=Triangle* WS*
		//	'endsolid' EString? (ID | WS | STRING | DOUBLE | ANY_OTHER)*;
		@Override public ParserRule getRule() { return rule; }
		
		//{Shape} 'solid' name=EString? (ID | WS | STRING | DOUBLE | ANY_OTHER)* triangles+=Triangle* WS* 'endsolid' EString? (ID
		//| WS | STRING | DOUBLE | ANY_OTHER)*
		public Group getGroup() { return cGroup; }
		
		//{Shape}
		public Action getShapeAction_0() { return cShapeAction_0; }
		
		//'solid'
		public Keyword getSolidKeyword_1() { return cSolidKeyword_1; }
		
		//name=EString?
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//EString
		public RuleCall getNameEStringParserRuleCall_2_0() { return cNameEStringParserRuleCall_2_0; }
		
		//(ID | WS | STRING | DOUBLE | ANY_OTHER)*
		public Alternatives getAlternatives_3() { return cAlternatives_3; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_3_0() { return cIDTerminalRuleCall_3_0; }
		
		//WS
		public RuleCall getWSTerminalRuleCall_3_1() { return cWSTerminalRuleCall_3_1; }
		
		//STRING
		public RuleCall getSTRINGTerminalRuleCall_3_2() { return cSTRINGTerminalRuleCall_3_2; }
		
		//DOUBLE
		public RuleCall getDOUBLETerminalRuleCall_3_3() { return cDOUBLETerminalRuleCall_3_3; }
		
		//ANY_OTHER
		public RuleCall getANY_OTHERTerminalRuleCall_3_4() { return cANY_OTHERTerminalRuleCall_3_4; }
		
		//triangles+=Triangle*
		public Assignment getTrianglesAssignment_4() { return cTrianglesAssignment_4; }
		
		//Triangle
		public RuleCall getTrianglesTriangleParserRuleCall_4_0() { return cTrianglesTriangleParserRuleCall_4_0; }
		
		//WS*
		public RuleCall getWSTerminalRuleCall_5() { return cWSTerminalRuleCall_5; }
		
		//'endsolid'
		public Keyword getEndsolidKeyword_6() { return cEndsolidKeyword_6; }
		
		//EString?
		public RuleCall getEStringParserRuleCall_7() { return cEStringParserRuleCall_7; }
		
		//(ID | WS | STRING | DOUBLE | ANY_OTHER)*
		public Alternatives getAlternatives_8() { return cAlternatives_8; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_8_0() { return cIDTerminalRuleCall_8_0; }
		
		//WS
		public RuleCall getWSTerminalRuleCall_8_1() { return cWSTerminalRuleCall_8_1; }
		
		//STRING
		public RuleCall getSTRINGTerminalRuleCall_8_2() { return cSTRINGTerminalRuleCall_8_2; }
		
		//DOUBLE
		public RuleCall getDOUBLETerminalRuleCall_8_3() { return cDOUBLETerminalRuleCall_8_3; }
		
		//ANY_OTHER
		public RuleCall getANY_OTHERTerminalRuleCall_8_4() { return cANY_OTHERTerminalRuleCall_8_4; }
	}
	public class TriangleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.january.geometry.model.STL.Triangle");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cTriangleAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cFacetKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cNormalKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cNormalAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cNormalVertexParserRuleCall_2_1_0 = (RuleCall)cNormalAssignment_2_1.eContents().get(0);
		private final Keyword cOuterKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cLoopKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cVertexKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cVerticesAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cVerticesVertexParserRuleCall_5_1_0 = (RuleCall)cVerticesAssignment_5_1.eContents().get(0);
		private final Keyword cEndloopKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Keyword cEndfacetKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//Triangle:
		//	{Triangle}
		//	'facet' ('normal' normal=Vertex)
		//	'outer' 'loop' ('vertex' vertices+=Vertex)*
		//	'endloop'
		//	'endfacet';
		@Override public ParserRule getRule() { return rule; }
		
		//{Triangle} 'facet' ('normal' normal=Vertex) 'outer' 'loop' ('vertex' vertices+=Vertex)* 'endloop' 'endfacet'
		public Group getGroup() { return cGroup; }
		
		//{Triangle}
		public Action getTriangleAction_0() { return cTriangleAction_0; }
		
		//'facet'
		public Keyword getFacetKeyword_1() { return cFacetKeyword_1; }
		
		//'normal' normal=Vertex
		public Group getGroup_2() { return cGroup_2; }
		
		//'normal'
		public Keyword getNormalKeyword_2_0() { return cNormalKeyword_2_0; }
		
		//normal=Vertex
		public Assignment getNormalAssignment_2_1() { return cNormalAssignment_2_1; }
		
		//Vertex
		public RuleCall getNormalVertexParserRuleCall_2_1_0() { return cNormalVertexParserRuleCall_2_1_0; }
		
		//'outer'
		public Keyword getOuterKeyword_3() { return cOuterKeyword_3; }
		
		//'loop'
		public Keyword getLoopKeyword_4() { return cLoopKeyword_4; }
		
		//('vertex' vertices+=Vertex)*
		public Group getGroup_5() { return cGroup_5; }
		
		//'vertex'
		public Keyword getVertexKeyword_5_0() { return cVertexKeyword_5_0; }
		
		//vertices+=Vertex
		public Assignment getVerticesAssignment_5_1() { return cVerticesAssignment_5_1; }
		
		//Vertex
		public RuleCall getVerticesVertexParserRuleCall_5_1_0() { return cVerticesVertexParserRuleCall_5_1_0; }
		
		//'endloop'
		public Keyword getEndloopKeyword_6() { return cEndloopKeyword_6; }
		
		//'endfacet'
		public Keyword getEndfacetKeyword_7() { return cEndfacetKeyword_7; }
	}
	public class VertexElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.january.geometry.model.STL.Vertex");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cVertexAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cXAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cXDOUBLETerminalRuleCall_1_0 = (RuleCall)cXAssignment_1.eContents().get(0);
		private final Assignment cYAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cYDOUBLETerminalRuleCall_2_0 = (RuleCall)cYAssignment_2.eContents().get(0);
		private final Assignment cZAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cZDOUBLETerminalRuleCall_3_0 = (RuleCall)cZAssignment_3.eContents().get(0);
		
		//Vertex:
		//	{Vertex} x=DOUBLE
		//	y=DOUBLE
		//	z=DOUBLE;
		@Override public ParserRule getRule() { return rule; }
		
		//{Vertex} x=DOUBLE y=DOUBLE z=DOUBLE
		public Group getGroup() { return cGroup; }
		
		//{Vertex}
		public Action getVertexAction_0() { return cVertexAction_0; }
		
		//x=DOUBLE
		public Assignment getXAssignment_1() { return cXAssignment_1; }
		
		//DOUBLE
		public RuleCall getXDOUBLETerminalRuleCall_1_0() { return cXDOUBLETerminalRuleCall_1_0; }
		
		//y=DOUBLE
		public Assignment getYAssignment_2() { return cYAssignment_2; }
		
		//DOUBLE
		public RuleCall getYDOUBLETerminalRuleCall_2_0() { return cYDOUBLETerminalRuleCall_2_0; }
		
		//z=DOUBLE
		public Assignment getZAssignment_3() { return cZAssignment_3; }
		
		//DOUBLE
		public RuleCall getZDOUBLETerminalRuleCall_3_0() { return cZDOUBLETerminalRuleCall_3_0; }
	}
	public class EStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.january.geometry.model.STL.EString");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSTRINGTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//EString:
		//	STRING | ID;
		@Override public ParserRule getRule() { return rule; }
		
		//STRING | ID
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//STRING
		public RuleCall getSTRINGTerminalRuleCall_0() { return cSTRINGTerminalRuleCall_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }
	}
	
	
	private final GeometryElements pGeometry;
	private final Shape_ImplElements pShape_Impl;
	private final TriangleElements pTriangle;
	private final VertexElements pVertex;
	private final TerminalRule tDOUBLE;
	private final EStringElements pEString;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public STLGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pGeometry = new GeometryElements();
		this.pShape_Impl = new Shape_ImplElements();
		this.pTriangle = new TriangleElements();
		this.pVertex = new VertexElements();
		this.tDOUBLE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.january.geometry.model.STL.DOUBLE");
		this.pEString = new EStringElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.january.geometry.model.STL".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Geometry:
	//	{Geometry} nodes+=Shape_Impl*;
	public GeometryElements getGeometryAccess() {
		return pGeometry;
	}
	
	public ParserRule getGeometryRule() {
		return getGeometryAccess().getRule();
	}
	
	//Shape_Impl Shape:
	//	{Shape}
	//	'solid'
	//	name=EString? (ID | WS | STRING | DOUBLE | ANY_OTHER)*
	//	triangles+=Triangle* WS*
	//	'endsolid' EString? (ID | WS | STRING | DOUBLE | ANY_OTHER)*;
	public Shape_ImplElements getShape_ImplAccess() {
		return pShape_Impl;
	}
	
	public ParserRule getShape_ImplRule() {
		return getShape_ImplAccess().getRule();
	}
	
	//Triangle:
	//	{Triangle}
	//	'facet' ('normal' normal=Vertex)
	//	'outer' 'loop' ('vertex' vertices+=Vertex)*
	//	'endloop'
	//	'endfacet';
	public TriangleElements getTriangleAccess() {
		return pTriangle;
	}
	
	public ParserRule getTriangleRule() {
		return getTriangleAccess().getRule();
	}
	
	//Vertex:
	//	{Vertex} x=DOUBLE
	//	y=DOUBLE
	//	z=DOUBLE;
	public VertexElements getVertexAccess() {
		return pVertex;
	}
	
	public ParserRule getVertexRule() {
		return getVertexAccess().getRule();
	}
	
	//terminal DOUBLE returns ecore::EDouble:
	//	('-' | '+')? INT? '.' INT (('E' | 'e') ('-' | '+')? INT)? | INT;
	public TerminalRule getDOUBLERule() {
		return tDOUBLE;
	}
	
	//EString:
	//	STRING | ID;
	public EStringElements getEStringAccess() {
		return pEString;
	}
	
	public ParserRule getEStringRule() {
		return getEStringAccess().getRule();
	}
	
	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' | "'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
