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
package xtext.services;

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
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "xtext.STL.Geometry");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cGeometryAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cSolidKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameEStringParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Assignment cNodesAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNodesShape_ImplParserRuleCall_3_0 = (RuleCall)cNodesAssignment_3.eContents().get(0);
		private final Keyword cControl000aKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cEndsolidKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final RuleCall cEStringParserRuleCall_6 = (RuleCall)cGroup.eContents().get(6);
		
		//Geometry:
		//	{Geometry}
		//	'solid'
		//	name=EString?
		//	nodes+=Shape_Impl '\n'?
		//	'endsolid' EString?;
		@Override public ParserRule getRule() { return rule; }
		
		//{Geometry} 'solid' name=EString? nodes+=Shape_Impl '\n'? 'endsolid' EString?
		public Group getGroup() { return cGroup; }
		
		//{Geometry}
		public Action getGeometryAction_0() { return cGeometryAction_0; }
		
		//'solid'
		public Keyword getSolidKeyword_1() { return cSolidKeyword_1; }
		
		//name=EString?
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//EString
		public RuleCall getNameEStringParserRuleCall_2_0() { return cNameEStringParserRuleCall_2_0; }
		
		//nodes+=Shape_Impl
		public Assignment getNodesAssignment_3() { return cNodesAssignment_3; }
		
		//Shape_Impl
		public RuleCall getNodesShape_ImplParserRuleCall_3_0() { return cNodesShape_ImplParserRuleCall_3_0; }
		
		//'\n'?
		public Keyword getControl000aKeyword_4() { return cControl000aKeyword_4; }
		
		//'endsolid'
		public Keyword getEndsolidKeyword_5() { return cEndsolidKeyword_5; }
		
		//EString?
		public RuleCall getEStringParserRuleCall_6() { return cEStringParserRuleCall_6; }
	}
	public class Shape_ImplElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "xtext.STL.Shape_Impl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cShapeAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cTrianglesAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTrianglesTriangleParserRuleCall_1_0 = (RuleCall)cTrianglesAssignment_1.eContents().get(0);
		
		//Shape_Impl Shape:
		//	{Shape} triangles+=Triangle*
		@Override public ParserRule getRule() { return rule; }
		
		//{Shape} triangles+=Triangle*
		public Group getGroup() { return cGroup; }
		
		//{Shape}
		public Action getShapeAction_0() { return cShapeAction_0; }
		
		//triangles+=Triangle*
		public Assignment getTrianglesAssignment_1() { return cTrianglesAssignment_1; }
		
		//Triangle
		public RuleCall getTrianglesTriangleParserRuleCall_1_0() { return cTrianglesTriangleParserRuleCall_1_0; }
	}
	public class TriangleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "xtext.STL.Triangle");
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
		
		//('normal' normal=Vertex)
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
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "xtext.STL.Vertex");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cVertexAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cXAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cXEDoubleParserRuleCall_1_0 = (RuleCall)cXAssignment_1.eContents().get(0);
		private final Assignment cYAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cYEDoubleParserRuleCall_2_0 = (RuleCall)cYAssignment_2.eContents().get(0);
		private final Assignment cZAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cZEDoubleParserRuleCall_3_0 = (RuleCall)cZAssignment_3.eContents().get(0);
		
		//Vertex:
		//	{Vertex} x=EDouble
		//	y=EDouble
		//	z=EDouble;
		@Override public ParserRule getRule() { return rule; }
		
		//{Vertex} x=EDouble y=EDouble z=EDouble
		public Group getGroup() { return cGroup; }
		
		//{Vertex}
		public Action getVertexAction_0() { return cVertexAction_0; }
		
		//x=EDouble
		public Assignment getXAssignment_1() { return cXAssignment_1; }
		
		//EDouble
		public RuleCall getXEDoubleParserRuleCall_1_0() { return cXEDoubleParserRuleCall_1_0; }
		
		//y=EDouble
		public Assignment getYAssignment_2() { return cYAssignment_2; }
		
		//EDouble
		public RuleCall getYEDoubleParserRuleCall_2_0() { return cYEDoubleParserRuleCall_2_0; }
		
		//z=EDouble
		public Assignment getZAssignment_3() { return cZAssignment_3; }
		
		//EDouble
		public RuleCall getZEDoubleParserRuleCall_3_0() { return cZEDoubleParserRuleCall_3_0; }
	}
	public class EDoubleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "xtext.STL.EDouble");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Keyword cPlusSignKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final RuleCall cINTTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Alternatives cAlternatives_4_0 = (Alternatives)cGroup_4.eContents().get(0);
		private final Keyword cEKeyword_4_0_0 = (Keyword)cAlternatives_4_0.eContents().get(0);
		private final Keyword cEKeyword_4_0_1 = (Keyword)cAlternatives_4_0.eContents().get(1);
		private final Alternatives cAlternatives_4_1 = (Alternatives)cGroup_4.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_4_1_0 = (Keyword)cAlternatives_4_1.eContents().get(0);
		private final Keyword cPlusSignKeyword_4_1_1 = (Keyword)cAlternatives_4_1.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_4_2 = (RuleCall)cGroup_4.eContents().get(2);
		
		//EDouble ecore::EDouble:
		//	('-' | '+')? INT? '.' INT (('E' | 'e') ('-' | '+')? INT)?
		@Override public ParserRule getRule() { return rule; }
		
		//('-' | '+')? INT? '.' INT (('E' | 'e') ('-' | '+')? INT)?
		public Group getGroup() { return cGroup; }
		
		//('-' | '+')?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//'-'
		public Keyword getHyphenMinusKeyword_0_0() { return cHyphenMinusKeyword_0_0; }
		
		//'+'
		public Keyword getPlusSignKeyword_0_1() { return cPlusSignKeyword_0_1; }
		
		//INT?
		public RuleCall getINTTerminalRuleCall_1() { return cINTTerminalRuleCall_1; }
		
		//'.'
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_3() { return cINTTerminalRuleCall_3; }
		
		//(('E' | 'e') ('-' | '+')? INT)?
		public Group getGroup_4() { return cGroup_4; }
		
		//('E' | 'e')
		public Alternatives getAlternatives_4_0() { return cAlternatives_4_0; }
		
		//'E'
		public Keyword getEKeyword_4_0_0() { return cEKeyword_4_0_0; }
		
		//'e'
		public Keyword getEKeyword_4_0_1() { return cEKeyword_4_0_1; }
		
		//('-' | '+')?
		public Alternatives getAlternatives_4_1() { return cAlternatives_4_1; }
		
		//'-'
		public Keyword getHyphenMinusKeyword_4_1_0() { return cHyphenMinusKeyword_4_1_0; }
		
		//'+'
		public Keyword getPlusSignKeyword_4_1_1() { return cPlusSignKeyword_4_1_1; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_4_2() { return cINTTerminalRuleCall_4_2; }
	}
	public class EStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "xtext.STL.EString");
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
	private final EDoubleElements pEDouble;
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
		this.pEDouble = new EDoubleElements();
		this.pEString = new EStringElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("xtext.STL".equals(grammar.getName())) {
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
	//	{Geometry}
	//	'solid'
	//	name=EString?
	//	nodes+=Shape_Impl '\n'?
	//	'endsolid' EString?;
	public GeometryElements getGeometryAccess() {
		return pGeometry;
	}
	
	public ParserRule getGeometryRule() {
		return getGeometryAccess().getRule();
	}
	
	//Shape_Impl Shape:
	//	{Shape} triangles+=Triangle*
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
	//	{Vertex} x=EDouble
	//	y=EDouble
	//	z=EDouble;
	public VertexElements getVertexAccess() {
		return pVertex;
	}
	
	public ParserRule getVertexRule() {
		return getVertexAccess().getRule();
	}
	
	//EDouble ecore::EDouble:
	//	('-' | '+')? INT? '.' INT (('E' | 'e') ('-' | '+')? INT)?
	public EDoubleElements getEDoubleAccess() {
		return pEDouble;
	}
	
	public ParserRule getEDoubleRule() {
		return getEDoubleAccess().getRule();
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
	//	'"' ('\\' . | !('\\' | '"'))* '"' |
	//	"'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//	'/ *'->'* /';
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
