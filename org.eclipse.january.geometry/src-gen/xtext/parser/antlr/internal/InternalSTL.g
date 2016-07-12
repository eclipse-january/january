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
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import xtext.services.STLGrammarAccess;

}

@parser::members {

 	private STLGrammarAccess grammarAccess;

    public InternalSTLParser(TokenStream input, STLGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Geometry";
   	}

   	@Override
   	protected STLGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleGeometry
entryRuleGeometry returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getGeometryRule()); }
	iv_ruleGeometry=ruleGeometry
	{ $current=$iv_ruleGeometry.current; }
	EOF;

// Rule Geometry
ruleGeometry returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getGeometryAccess().getGeometryAction_0(),
					$current);
			}
		)
		otherlv_1='solid'
		{
			newLeafNode(otherlv_1, grammarAccess.getGeometryAccess().getSolidKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getGeometryAccess().getNameELineParserRuleCall_2_0());
				}
				lv_name_2_0=ruleELine
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getGeometryRule());
					}
					set(
						$current,
						"name",
						lv_name_2_0,
						"xtext.STL.ELine");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getGeometryAccess().getNodesShape_ImplParserRuleCall_3_0());
				}
				lv_nodes_3_0=ruleShape_Impl
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getGeometryRule());
					}
					add(
						$current,
						"nodes",
						lv_nodes_3_0,
						"xtext.STL.Shape_Impl");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='endsolid'
		{
			newLeafNode(otherlv_4, grammarAccess.getGeometryAccess().getEndsolidKeyword_4());
		}
	)
;

// Entry rule entryRuleShape_Impl
entryRuleShape_Impl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getShape_ImplRule()); }
	iv_ruleShape_Impl=ruleShape_Impl
	{ $current=$iv_ruleShape_Impl.current; }
	EOF;

// Rule Shape_Impl
ruleShape_Impl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getShape_ImplAccess().getShapeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getShape_ImplAccess().getTrianglesTriangleParserRuleCall_1_0());
				}
				lv_triangles_1_0=ruleTriangle
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getShape_ImplRule());
					}
					add(
						$current,
						"triangles",
						lv_triangles_1_0,
						"xtext.STL.Triangle");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;

// Entry rule entryRuleTriangle
entryRuleTriangle returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTriangleRule()); }
	iv_ruleTriangle=ruleTriangle
	{ $current=$iv_ruleTriangle.current; }
	EOF;

// Rule Triangle
ruleTriangle returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getTriangleAccess().getTriangleAction_0(),
					$current);
			}
		)
		otherlv_1='facet'
		{
			newLeafNode(otherlv_1, grammarAccess.getTriangleAccess().getFacetKeyword_1());
		}
		(
			otherlv_2='normal'
			{
				newLeafNode(otherlv_2, grammarAccess.getTriangleAccess().getNormalKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTriangleAccess().getNormalVertexParserRuleCall_2_1_0());
					}
					lv_normal_3_0=ruleVertex
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTriangleRule());
						}
						set(
							$current,
							"normal",
							lv_normal_3_0,
							"xtext.STL.Vertex");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		otherlv_4='outer'
		{
			newLeafNode(otherlv_4, grammarAccess.getTriangleAccess().getOuterKeyword_3());
		}
		otherlv_5='loop'
		{
			newLeafNode(otherlv_5, grammarAccess.getTriangleAccess().getLoopKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTriangleAccess().getVerticesVertexParserRuleCall_5_0());
				}
				lv_vertices_6_0=ruleVertex
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTriangleRule());
					}
					add(
						$current,
						"vertices",
						lv_vertices_6_0,
						"xtext.STL.Vertex");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_7='endloop'
		{
			newLeafNode(otherlv_7, grammarAccess.getTriangleAccess().getEndloopKeyword_6());
		}
		otherlv_8='endfacet'
		{
			newLeafNode(otherlv_8, grammarAccess.getTriangleAccess().getEndfacetKeyword_7());
		}
	)
;

// Entry rule entryRuleVertex
entryRuleVertex returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getVertexRule()); }
	iv_ruleVertex=ruleVertex
	{ $current=$iv_ruleVertex.current; }
	EOF;

// Rule Vertex
ruleVertex returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getVertexAccess().getVertexAction_0(),
					$current);
			}
		)
		otherlv_1='vertex'
		{
			newLeafNode(otherlv_1, grammarAccess.getVertexAccess().getVertexKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getVertexAccess().getXEDoubleParserRuleCall_2_0());
				}
				lv_x_2_0=ruleEDouble
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVertexRule());
					}
					set(
						$current,
						"x",
						lv_x_2_0,
						"xtext.STL.EDouble");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getVertexAccess().getYEDoubleParserRuleCall_3_0());
				}
				lv_y_3_0=ruleEDouble
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVertexRule());
					}
					set(
						$current,
						"y",
						lv_y_3_0,
						"xtext.STL.EDouble");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getVertexAccess().getZEDoubleParserRuleCall_4_0());
				}
				lv_z_4_0=ruleEDouble
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getVertexRule());
					}
					set(
						$current,
						"z",
						lv_z_4_0,
						"xtext.STL.EDouble");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleEDouble
entryRuleEDouble returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEDoubleRule()); }
	iv_ruleEDouble=ruleEDouble
	{ $current=$iv_ruleEDouble.current.getText(); }
	EOF;

// Rule EDouble
ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			kw='-'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0_0());
			}
			    |
			kw='+'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getEDoubleAccess().getPlusSignKeyword_0_1());
			}
		)?
		(
			this_INT_2=RULE_INT
			{
				$current.merge(this_INT_2);
			}
			{
				newLeafNode(this_INT_2, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
			}
		)?
		kw='.'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2());
		}
		this_INT_4=RULE_INT
		{
			$current.merge(this_INT_4);
		}
		{
			newLeafNode(this_INT_4, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3());
		}
		(
			(
				kw='E'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0());
				}
				    |
				kw='e'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1());
				}
			)
			(
				kw='-'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1_0());
				}
				    |
				kw='+'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getEDoubleAccess().getPlusSignKeyword_4_1_1());
				}
			)?
			this_INT_9=RULE_INT
			{
				$current.merge(this_INT_9);
			}
			{
				newLeafNode(this_INT_9, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2());
			}
		)?
	)
;

// Entry rule entryRuleELine
entryRuleELine returns [String current=null]:
	{ newCompositeNode(grammarAccess.getELineRule()); }
	iv_ruleELine=ruleELine
	{ $current=$iv_ruleELine.current.getText(); }
	EOF;

// Rule ELine
ruleELine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_STRING_0=RULE_STRING
		{
			$current.merge(this_STRING_0);
		}
		{
			newLeafNode(this_STRING_0, grammarAccess.getELineAccess().getSTRINGTerminalRuleCall_0());
		}
		    |
		(
			this_ID_1=RULE_ID
			{
				$current.merge(this_ID_1);
			}
			{
				newLeafNode(this_ID_1, grammarAccess.getELineAccess().getIDTerminalRuleCall_1_0());
			}
			(
				('\r' | '\n')=>
				(
					(
						kw='\r'
						{
							$current.merge(kw);
							newLeafNode(kw, grammarAccess.getELineAccess().getControl000dKeyword_1_1_0_0());
						}
					)?
					    |
					kw='\n'
					{
						$current.merge(kw);
						newLeafNode(kw, grammarAccess.getELineAccess().getControl000aKeyword_1_1_0_1());
					}
				)
			)
		)
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
