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
grammar InternalSTL;

options {
	superClass=AbstractInternalContentAssistParser;
}

@lexer::header {
package xtext.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package xtext.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import xtext.services.STLGrammarAccess;

}
@parser::members {
	private STLGrammarAccess grammarAccess;

	public void setGrammarAccess(STLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}
}

// Entry rule entryRuleGeometry
entryRuleGeometry
:
{ before(grammarAccess.getGeometryRule()); }
	 ruleGeometry
{ after(grammarAccess.getGeometryRule()); } 
	 EOF 
;

// Rule Geometry
ruleGeometry 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getGeometryAccess().getGroup()); }
		(rule__Geometry__Group__0)
		{ after(grammarAccess.getGeometryAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleShape_Impl
entryRuleShape_Impl
:
{ before(grammarAccess.getShape_ImplRule()); }
	 ruleShape_Impl
{ after(grammarAccess.getShape_ImplRule()); } 
	 EOF 
;

// Rule Shape_Impl
ruleShape_Impl 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getShape_ImplAccess().getGroup()); }
		(rule__Shape_Impl__Group__0)
		{ after(grammarAccess.getShape_ImplAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTriangle
entryRuleTriangle
:
{ before(grammarAccess.getTriangleRule()); }
	 ruleTriangle
{ after(grammarAccess.getTriangleRule()); } 
	 EOF 
;

// Rule Triangle
ruleTriangle 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTriangleAccess().getGroup()); }
		(rule__Triangle__Group__0)
		{ after(grammarAccess.getTriangleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleVertex
entryRuleVertex
:
{ before(grammarAccess.getVertexRule()); }
	 ruleVertex
{ after(grammarAccess.getVertexRule()); } 
	 EOF 
;

// Rule Vertex
ruleVertex 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getVertexAccess().getGroup()); }
		(rule__Vertex__Group__0)
		{ after(grammarAccess.getVertexAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEDouble
entryRuleEDouble
:
{ before(grammarAccess.getEDoubleRule()); }
	 ruleEDouble
{ after(grammarAccess.getEDoubleRule()); } 
	 EOF 
;

// Rule EDouble
ruleEDouble 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEDoubleAccess().getGroup()); }
		(rule__EDouble__Group__0)
		{ after(grammarAccess.getEDoubleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEString
entryRuleEString
:
{ before(grammarAccess.getEStringRule()); }
	 ruleEString
{ after(grammarAccess.getEStringRule()); } 
	 EOF 
;

// Rule EString
ruleEString 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEStringAccess().getAlternatives()); }
		(rule__EString__Alternatives)
		{ after(grammarAccess.getEStringAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Alternatives_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_3_0()); }
	)
	|
	(
		{ before(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_3_1()); }
		RULE_WS
		{ after(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_3_1()); }
	)
	|
	(
		{ before(grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_3_2()); }
		RULE_STRING
		{ after(grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_3_2()); }
	)
	|
	(
		{ before(grammarAccess.getShape_ImplAccess().getINTTerminalRuleCall_3_3()); }
		RULE_INT
		{ after(grammarAccess.getShape_ImplAccess().getINTTerminalRuleCall_3_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Alternatives_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_8_0()); }
		RULE_ID
		{ after(grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_8_0()); }
	)
	|
	(
		{ before(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_8_1()); }
		RULE_WS
		{ after(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_8_1()); }
	)
	|
	(
		{ before(grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_8_2()); }
		RULE_STRING
		{ after(grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_8_2()); }
	)
	|
	(
		{ before(grammarAccess.getShape_ImplAccess().getINTTerminalRuleCall_8_3()); }
		RULE_INT
		{ after(grammarAccess.getShape_ImplAccess().getINTTerminalRuleCall_8_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Alternatives_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0_0()); }
		'-'
		{ after(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getEDoubleAccess().getPlusSignKeyword_0_1()); }
		'+'
		{ after(grammarAccess.getEDoubleAccess().getPlusSignKeyword_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Alternatives_4_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); }
		'E'
		{ after(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); }
		'e'
		{ after(grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Alternatives_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1_0()); }
		'-'
		{ after(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getEDoubleAccess().getPlusSignKeyword_4_1_1()); }
		'+'
		{ after(grammarAccess.getEDoubleAccess().getPlusSignKeyword_4_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EString__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); }
		RULE_STRING
		{ after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); }
		RULE_ID
		{ after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Geometry__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Geometry__Group__0__Impl
	rule__Geometry__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Geometry__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGeometryAccess().getGeometryAction_0()); }
	()
	{ after(grammarAccess.getGeometryAccess().getGeometryAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Geometry__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Geometry__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Geometry__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGeometryAccess().getNodesAssignment_1()); }
	(rule__Geometry__NodesAssignment_1)*
	{ after(grammarAccess.getGeometryAccess().getNodesAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Shape_Impl__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Shape_Impl__Group__0__Impl
	rule__Shape_Impl__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShape_ImplAccess().getShapeAction_0()); }
	()
	{ after(grammarAccess.getShape_ImplAccess().getShapeAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Shape_Impl__Group__1__Impl
	rule__Shape_Impl__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShape_ImplAccess().getSolidKeyword_1()); }
	'solid'
	{ after(grammarAccess.getShape_ImplAccess().getSolidKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Shape_Impl__Group__2__Impl
	rule__Shape_Impl__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShape_ImplAccess().getNameAssignment_2()); }
	(rule__Shape_Impl__NameAssignment_2)?
	{ after(grammarAccess.getShape_ImplAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Shape_Impl__Group__3__Impl
	rule__Shape_Impl__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShape_ImplAccess().getAlternatives_3()); }
	(rule__Shape_Impl__Alternatives_3)*
	{ after(grammarAccess.getShape_ImplAccess().getAlternatives_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Shape_Impl__Group__4__Impl
	rule__Shape_Impl__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShape_ImplAccess().getTrianglesAssignment_4()); }
	(rule__Shape_Impl__TrianglesAssignment_4)*
	{ after(grammarAccess.getShape_ImplAccess().getTrianglesAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Shape_Impl__Group__5__Impl
	rule__Shape_Impl__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_5()); }
	(RULE_WS)*
	{ after(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Shape_Impl__Group__6__Impl
	rule__Shape_Impl__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShape_ImplAccess().getEndsolidKeyword_6()); }
	'endsolid'
	{ after(grammarAccess.getShape_ImplAccess().getEndsolidKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Shape_Impl__Group__7__Impl
	rule__Shape_Impl__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShape_ImplAccess().getEStringParserRuleCall_7()); }
	(ruleEString)?
	{ after(grammarAccess.getShape_ImplAccess().getEStringParserRuleCall_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Shape_Impl__Group__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShape_ImplAccess().getAlternatives_8()); }
	(rule__Shape_Impl__Alternatives_8)*
	{ after(grammarAccess.getShape_ImplAccess().getAlternatives_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Triangle__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Triangle__Group__0__Impl
	rule__Triangle__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriangleAccess().getTriangleAction_0()); }
	()
	{ after(grammarAccess.getTriangleAccess().getTriangleAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Triangle__Group__1__Impl
	rule__Triangle__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriangleAccess().getFacetKeyword_1()); }
	'facet'
	{ after(grammarAccess.getTriangleAccess().getFacetKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Triangle__Group__2__Impl
	rule__Triangle__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriangleAccess().getGroup_2()); }
	(rule__Triangle__Group_2__0)
	{ after(grammarAccess.getTriangleAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Triangle__Group__3__Impl
	rule__Triangle__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriangleAccess().getOuterKeyword_3()); }
	'outer'
	{ after(grammarAccess.getTriangleAccess().getOuterKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Triangle__Group__4__Impl
	rule__Triangle__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriangleAccess().getLoopKeyword_4()); }
	'loop'
	{ after(grammarAccess.getTriangleAccess().getLoopKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Triangle__Group__5__Impl
	rule__Triangle__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriangleAccess().getVertexKeyword_5()); }
	'vertex'
	{ after(grammarAccess.getTriangleAccess().getVertexKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Triangle__Group__6__Impl
	rule__Triangle__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriangleAccess().getVertex1Assignment_6()); }
	(rule__Triangle__Vertex1Assignment_6)
	{ after(grammarAccess.getTriangleAccess().getVertex1Assignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Triangle__Group__7__Impl
	rule__Triangle__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriangleAccess().getVertexKeyword_7()); }
	'vertex'
	{ after(grammarAccess.getTriangleAccess().getVertexKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Triangle__Group__8__Impl
	rule__Triangle__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriangleAccess().getVertex2Assignment_8()); }
	(rule__Triangle__Vertex2Assignment_8)
	{ after(grammarAccess.getTriangleAccess().getVertex2Assignment_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Triangle__Group__9__Impl
	rule__Triangle__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriangleAccess().getVertexKeyword_9()); }
	'vertex'
	{ after(grammarAccess.getTriangleAccess().getVertexKeyword_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__10
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Triangle__Group__10__Impl
	rule__Triangle__Group__11
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__10__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriangleAccess().getVertex3Assignment_10()); }
	(rule__Triangle__Vertex3Assignment_10)
	{ after(grammarAccess.getTriangleAccess().getVertex3Assignment_10()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__11
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Triangle__Group__11__Impl
	rule__Triangle__Group__12
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__11__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriangleAccess().getEndloopKeyword_11()); }
	'endloop'
	{ after(grammarAccess.getTriangleAccess().getEndloopKeyword_11()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__12
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Triangle__Group__12__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group__12__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriangleAccess().getEndfacetKeyword_12()); }
	'endfacet'
	{ after(grammarAccess.getTriangleAccess().getEndfacetKeyword_12()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Triangle__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Triangle__Group_2__0__Impl
	rule__Triangle__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriangleAccess().getNormalKeyword_2_0()); }
	'normal'
	{ after(grammarAccess.getTriangleAccess().getNormalKeyword_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Triangle__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTriangleAccess().getNormalAssignment_2_1()); }
	(rule__Triangle__NormalAssignment_2_1)
	{ after(grammarAccess.getTriangleAccess().getNormalAssignment_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Vertex__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Vertex__Group__0__Impl
	rule__Vertex__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Vertex__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVertexAccess().getVertexAction_0()); }
	()
	{ after(grammarAccess.getVertexAccess().getVertexAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vertex__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Vertex__Group__1__Impl
	rule__Vertex__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Vertex__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVertexAccess().getXAssignment_1()); }
	(rule__Vertex__XAssignment_1)
	{ after(grammarAccess.getVertexAccess().getXAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vertex__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Vertex__Group__2__Impl
	rule__Vertex__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Vertex__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVertexAccess().getYAssignment_2()); }
	(rule__Vertex__YAssignment_2)
	{ after(grammarAccess.getVertexAccess().getYAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vertex__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Vertex__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Vertex__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVertexAccess().getZAssignment_3()); }
	(rule__Vertex__ZAssignment_3)
	{ after(grammarAccess.getVertexAccess().getZAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EDouble__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EDouble__Group__0__Impl
	rule__EDouble__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEDoubleAccess().getAlternatives_0()); }
	(rule__EDouble__Alternatives_0)?
	{ after(grammarAccess.getEDoubleAccess().getAlternatives_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EDouble__Group__1__Impl
	rule__EDouble__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); }
	(RULE_INT)?
	{ after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EDouble__Group__2__Impl
	rule__EDouble__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); }
	'.'
	{ after(grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EDouble__Group__3__Impl
	rule__EDouble__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); }
	RULE_INT
	{ after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EDouble__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEDoubleAccess().getGroup_4()); }
	(rule__EDouble__Group_4__0)?
	{ after(grammarAccess.getEDoubleAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EDouble__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EDouble__Group_4__0__Impl
	rule__EDouble__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEDoubleAccess().getAlternatives_4_0()); }
	(rule__EDouble__Alternatives_4_0)
	{ after(grammarAccess.getEDoubleAccess().getAlternatives_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EDouble__Group_4__1__Impl
	rule__EDouble__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEDoubleAccess().getAlternatives_4_1()); }
	(rule__EDouble__Alternatives_4_1)?
	{ after(grammarAccess.getEDoubleAccess().getAlternatives_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EDouble__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EDouble__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2()); }
	RULE_INT
	{ after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Geometry__NodesAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getGeometryAccess().getNodesShape_ImplParserRuleCall_1_0()); }
		ruleShape_Impl
		{ after(grammarAccess.getGeometryAccess().getNodesShape_ImplParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getShape_ImplAccess().getNameEStringParserRuleCall_2_0()); }
		ruleEString
		{ after(grammarAccess.getShape_ImplAccess().getNameEStringParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Shape_Impl__TrianglesAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getShape_ImplAccess().getTrianglesTriangleParserRuleCall_4_0()); }
		ruleTriangle
		{ after(grammarAccess.getShape_ImplAccess().getTrianglesTriangleParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__NormalAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTriangleAccess().getNormalVertexParserRuleCall_2_1_0()); }
		ruleVertex
		{ after(grammarAccess.getTriangleAccess().getNormalVertexParserRuleCall_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Vertex1Assignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTriangleAccess().getVertex1VertexParserRuleCall_6_0()); }
		ruleVertex
		{ after(grammarAccess.getTriangleAccess().getVertex1VertexParserRuleCall_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Vertex2Assignment_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTriangleAccess().getVertex2VertexParserRuleCall_8_0()); }
		ruleVertex
		{ after(grammarAccess.getTriangleAccess().getVertex2VertexParserRuleCall_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Triangle__Vertex3Assignment_10
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTriangleAccess().getVertex3VertexParserRuleCall_10_0()); }
		ruleVertex
		{ after(grammarAccess.getTriangleAccess().getVertex3VertexParserRuleCall_10_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vertex__XAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVertexAccess().getXEDoubleParserRuleCall_1_0()); }
		ruleEDouble
		{ after(grammarAccess.getVertexAccess().getXEDoubleParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vertex__YAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVertexAccess().getYEDoubleParserRuleCall_2_0()); }
		ruleEDouble
		{ after(grammarAccess.getVertexAccess().getYEDoubleParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vertex__ZAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVertexAccess().getZEDoubleParserRuleCall_3_0()); }
		ruleEDouble
		{ after(grammarAccess.getVertexAccess().getZEDoubleParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
