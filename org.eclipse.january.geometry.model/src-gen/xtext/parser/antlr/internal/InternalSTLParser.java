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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
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
@SuppressWarnings("all")
public class InternalSTLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'solid'", "'endsolid'", "'facet'", "'normal'", "'outer'", "'loop'", "'endloop'", "'endfacet'", "'vertex'", "'-'", "'+'", "'.'", "'E'", "'e'", "'\\r'", "'\\n'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=6;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int RULE_INT=4;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalSTLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSTLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSTLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSTL.g"; }



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




    // $ANTLR start "entryRuleGeometry"
    // InternalSTL.g:72:1: entryRuleGeometry returns [EObject current=null] : iv_ruleGeometry= ruleGeometry EOF ;
    public final EObject entryRuleGeometry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeometry = null;


        try {
            // InternalSTL.g:72:49: (iv_ruleGeometry= ruleGeometry EOF )
            // InternalSTL.g:73:2: iv_ruleGeometry= ruleGeometry EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGeometryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGeometry=ruleGeometry();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGeometry; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeometry"


    // $ANTLR start "ruleGeometry"
    // InternalSTL.g:79:1: ruleGeometry returns [EObject current=null] : ( () otherlv_1= 'solid' ( (lv_name_2_0= ruleELine ) )? ( (lv_nodes_3_0= ruleShape_Impl ) ) otherlv_4= 'endsolid' ) ;
    public final EObject ruleGeometry() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_nodes_3_0 = null;



        	enterRule();

        try {
            // InternalSTL.g:85:2: ( ( () otherlv_1= 'solid' ( (lv_name_2_0= ruleELine ) )? ( (lv_nodes_3_0= ruleShape_Impl ) ) otherlv_4= 'endsolid' ) )
            // InternalSTL.g:86:2: ( () otherlv_1= 'solid' ( (lv_name_2_0= ruleELine ) )? ( (lv_nodes_3_0= ruleShape_Impl ) ) otherlv_4= 'endsolid' )
            {
            // InternalSTL.g:86:2: ( () otherlv_1= 'solid' ( (lv_name_2_0= ruleELine ) )? ( (lv_nodes_3_0= ruleShape_Impl ) ) otherlv_4= 'endsolid' )
            // InternalSTL.g:87:3: () otherlv_1= 'solid' ( (lv_name_2_0= ruleELine ) )? ( (lv_nodes_3_0= ruleShape_Impl ) ) otherlv_4= 'endsolid'
            {
            // InternalSTL.g:87:3: ()
            // InternalSTL.g:88:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getGeometryAccess().getGeometryAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,11,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getGeometryAccess().getSolidKeyword_1());
              		
            }
            // InternalSTL.g:98:3: ( (lv_name_2_0= ruleELine ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalSTL.g:99:4: (lv_name_2_0= ruleELine )
                    {
                    // InternalSTL.g:99:4: (lv_name_2_0= ruleELine )
                    // InternalSTL.g:100:5: lv_name_2_0= ruleELine
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getGeometryAccess().getNameELineParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_4);
                    lv_name_2_0=ruleELine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getGeometryRule());
                      					}
                      					set(
                      						current,
                      						"name",
                      						lv_name_2_0,
                      						"xtext.STL.ELine");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSTL.g:117:3: ( (lv_nodes_3_0= ruleShape_Impl ) )
            // InternalSTL.g:118:4: (lv_nodes_3_0= ruleShape_Impl )
            {
            // InternalSTL.g:118:4: (lv_nodes_3_0= ruleShape_Impl )
            // InternalSTL.g:119:5: lv_nodes_3_0= ruleShape_Impl
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getGeometryAccess().getNodesShape_ImplParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_nodes_3_0=ruleShape_Impl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getGeometryRule());
              					}
              					add(
              						current,
              						"nodes",
              						lv_nodes_3_0,
              						"xtext.STL.Shape_Impl");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getGeometryAccess().getEndsolidKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGeometry"


    // $ANTLR start "entryRuleShape_Impl"
    // InternalSTL.g:144:1: entryRuleShape_Impl returns [EObject current=null] : iv_ruleShape_Impl= ruleShape_Impl EOF ;
    public final EObject entryRuleShape_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShape_Impl = null;


        try {
            // InternalSTL.g:144:51: (iv_ruleShape_Impl= ruleShape_Impl EOF )
            // InternalSTL.g:145:2: iv_ruleShape_Impl= ruleShape_Impl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShape_ImplRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleShape_Impl=ruleShape_Impl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShape_Impl; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShape_Impl"


    // $ANTLR start "ruleShape_Impl"
    // InternalSTL.g:151:1: ruleShape_Impl returns [EObject current=null] : ( () ( (lv_triangles_1_0= ruleTriangle ) )* ) ;
    public final EObject ruleShape_Impl() throws RecognitionException {
        EObject current = null;

        EObject lv_triangles_1_0 = null;



        	enterRule();

        try {
            // InternalSTL.g:157:2: ( ( () ( (lv_triangles_1_0= ruleTriangle ) )* ) )
            // InternalSTL.g:158:2: ( () ( (lv_triangles_1_0= ruleTriangle ) )* )
            {
            // InternalSTL.g:158:2: ( () ( (lv_triangles_1_0= ruleTriangle ) )* )
            // InternalSTL.g:159:3: () ( (lv_triangles_1_0= ruleTriangle ) )*
            {
            // InternalSTL.g:159:3: ()
            // InternalSTL.g:160:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getShape_ImplAccess().getShapeAction_0(),
              					current);
              			
            }

            }

            // InternalSTL.g:166:3: ( (lv_triangles_1_0= ruleTriangle ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalSTL.g:167:4: (lv_triangles_1_0= ruleTriangle )
            	    {
            	    // InternalSTL.g:167:4: (lv_triangles_1_0= ruleTriangle )
            	    // InternalSTL.g:168:5: lv_triangles_1_0= ruleTriangle
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getShape_ImplAccess().getTrianglesTriangleParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_triangles_1_0=ruleTriangle();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getShape_ImplRule());
            	      					}
            	      					add(
            	      						current,
            	      						"triangles",
            	      						lv_triangles_1_0,
            	      						"xtext.STL.Triangle");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShape_Impl"


    // $ANTLR start "entryRuleTriangle"
    // InternalSTL.g:189:1: entryRuleTriangle returns [EObject current=null] : iv_ruleTriangle= ruleTriangle EOF ;
    public final EObject entryRuleTriangle() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriangle = null;


        try {
            // InternalSTL.g:189:49: (iv_ruleTriangle= ruleTriangle EOF )
            // InternalSTL.g:190:2: iv_ruleTriangle= ruleTriangle EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTriangleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTriangle=ruleTriangle();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTriangle; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTriangle"


    // $ANTLR start "ruleTriangle"
    // InternalSTL.g:196:1: ruleTriangle returns [EObject current=null] : ( () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' ( (lv_vertices_6_0= ruleVertex ) )* otherlv_7= 'endloop' otherlv_8= 'endfacet' ) ;
    public final EObject ruleTriangle() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_normal_3_0 = null;

        EObject lv_vertices_6_0 = null;



        	enterRule();

        try {
            // InternalSTL.g:202:2: ( ( () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' ( (lv_vertices_6_0= ruleVertex ) )* otherlv_7= 'endloop' otherlv_8= 'endfacet' ) )
            // InternalSTL.g:203:2: ( () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' ( (lv_vertices_6_0= ruleVertex ) )* otherlv_7= 'endloop' otherlv_8= 'endfacet' )
            {
            // InternalSTL.g:203:2: ( () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' ( (lv_vertices_6_0= ruleVertex ) )* otherlv_7= 'endloop' otherlv_8= 'endfacet' )
            // InternalSTL.g:204:3: () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' ( (lv_vertices_6_0= ruleVertex ) )* otherlv_7= 'endloop' otherlv_8= 'endfacet'
            {
            // InternalSTL.g:204:3: ()
            // InternalSTL.g:205:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTriangleAccess().getTriangleAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,13,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getTriangleAccess().getFacetKeyword_1());
              		
            }
            // InternalSTL.g:215:3: (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) )
            // InternalSTL.g:216:4: otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) )
            {
            otherlv_2=(Token)match(input,14,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_2, grammarAccess.getTriangleAccess().getNormalKeyword_2_0());
              			
            }
            // InternalSTL.g:220:4: ( (lv_normal_3_0= ruleVertex ) )
            // InternalSTL.g:221:5: (lv_normal_3_0= ruleVertex )
            {
            // InternalSTL.g:221:5: (lv_normal_3_0= ruleVertex )
            // InternalSTL.g:222:6: lv_normal_3_0= ruleVertex
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getTriangleAccess().getNormalVertexParserRuleCall_2_1_0());
              					
            }
            pushFollow(FOLLOW_9);
            lv_normal_3_0=ruleVertex();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getTriangleRule());
              						}
              						set(
              							current,
              							"normal",
              							lv_normal_3_0,
              							"xtext.STL.Vertex");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getTriangleAccess().getOuterKeyword_3());
              		
            }
            otherlv_5=(Token)match(input,16,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getTriangleAccess().getLoopKeyword_4());
              		
            }
            // InternalSTL.g:248:3: ( (lv_vertices_6_0= ruleVertex ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalSTL.g:249:4: (lv_vertices_6_0= ruleVertex )
            	    {
            	    // InternalSTL.g:249:4: (lv_vertices_6_0= ruleVertex )
            	    // InternalSTL.g:250:5: lv_vertices_6_0= ruleVertex
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getTriangleAccess().getVerticesVertexParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_vertices_6_0=ruleVertex();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getTriangleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"vertices",
            	      						lv_vertices_6_0,
            	      						"xtext.STL.Vertex");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getTriangleAccess().getEndloopKeyword_6());
              		
            }
            otherlv_8=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getTriangleAccess().getEndfacetKeyword_7());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTriangle"


    // $ANTLR start "entryRuleVertex"
    // InternalSTL.g:279:1: entryRuleVertex returns [EObject current=null] : iv_ruleVertex= ruleVertex EOF ;
    public final EObject entryRuleVertex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVertex = null;


        try {
            // InternalSTL.g:279:47: (iv_ruleVertex= ruleVertex EOF )
            // InternalSTL.g:280:2: iv_ruleVertex= ruleVertex EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVertexRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVertex=ruleVertex();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVertex; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVertex"


    // $ANTLR start "ruleVertex"
    // InternalSTL.g:286:1: ruleVertex returns [EObject current=null] : ( () otherlv_1= 'vertex' ( (lv_x_2_0= ruleEDouble ) ) ( (lv_y_3_0= ruleEDouble ) ) ( (lv_z_4_0= ruleEDouble ) ) ) ;
    public final EObject ruleVertex() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_x_2_0 = null;

        AntlrDatatypeRuleToken lv_y_3_0 = null;

        AntlrDatatypeRuleToken lv_z_4_0 = null;



        	enterRule();

        try {
            // InternalSTL.g:292:2: ( ( () otherlv_1= 'vertex' ( (lv_x_2_0= ruleEDouble ) ) ( (lv_y_3_0= ruleEDouble ) ) ( (lv_z_4_0= ruleEDouble ) ) ) )
            // InternalSTL.g:293:2: ( () otherlv_1= 'vertex' ( (lv_x_2_0= ruleEDouble ) ) ( (lv_y_3_0= ruleEDouble ) ) ( (lv_z_4_0= ruleEDouble ) ) )
            {
            // InternalSTL.g:293:2: ( () otherlv_1= 'vertex' ( (lv_x_2_0= ruleEDouble ) ) ( (lv_y_3_0= ruleEDouble ) ) ( (lv_z_4_0= ruleEDouble ) ) )
            // InternalSTL.g:294:3: () otherlv_1= 'vertex' ( (lv_x_2_0= ruleEDouble ) ) ( (lv_y_3_0= ruleEDouble ) ) ( (lv_z_4_0= ruleEDouble ) )
            {
            // InternalSTL.g:294:3: ()
            // InternalSTL.g:295:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVertexAccess().getVertexAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,19,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getVertexAccess().getVertexKeyword_1());
              		
            }
            // InternalSTL.g:305:3: ( (lv_x_2_0= ruleEDouble ) )
            // InternalSTL.g:306:4: (lv_x_2_0= ruleEDouble )
            {
            // InternalSTL.g:306:4: (lv_x_2_0= ruleEDouble )
            // InternalSTL.g:307:5: lv_x_2_0= ruleEDouble
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVertexAccess().getXEDoubleParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_x_2_0=ruleEDouble();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getVertexRule());
              					}
              					set(
              						current,
              						"x",
              						lv_x_2_0,
              						"xtext.STL.EDouble");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSTL.g:324:3: ( (lv_y_3_0= ruleEDouble ) )
            // InternalSTL.g:325:4: (lv_y_3_0= ruleEDouble )
            {
            // InternalSTL.g:325:4: (lv_y_3_0= ruleEDouble )
            // InternalSTL.g:326:5: lv_y_3_0= ruleEDouble
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVertexAccess().getYEDoubleParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_y_3_0=ruleEDouble();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getVertexRule());
              					}
              					set(
              						current,
              						"y",
              						lv_y_3_0,
              						"xtext.STL.EDouble");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSTL.g:343:3: ( (lv_z_4_0= ruleEDouble ) )
            // InternalSTL.g:344:4: (lv_z_4_0= ruleEDouble )
            {
            // InternalSTL.g:344:4: (lv_z_4_0= ruleEDouble )
            // InternalSTL.g:345:5: lv_z_4_0= ruleEDouble
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVertexAccess().getZEDoubleParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_z_4_0=ruleEDouble();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getVertexRule());
              					}
              					set(
              						current,
              						"z",
              						lv_z_4_0,
              						"xtext.STL.EDouble");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVertex"


    // $ANTLR start "entryRuleEDouble"
    // InternalSTL.g:366:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalSTL.g:366:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalSTL.g:367:2: iv_ruleEDouble= ruleEDouble EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEDoubleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEDouble=ruleEDouble();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEDouble.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEDouble"


    // $ANTLR start "ruleEDouble"
    // InternalSTL.g:373:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' | kw= '+' )? (this_INT_2= RULE_INT )? kw= '.' this_INT_4= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_9=null;


        	enterRule();

        try {
            // InternalSTL.g:379:2: ( ( (kw= '-' | kw= '+' )? (this_INT_2= RULE_INT )? kw= '.' this_INT_4= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )? ) )
            // InternalSTL.g:380:2: ( (kw= '-' | kw= '+' )? (this_INT_2= RULE_INT )? kw= '.' this_INT_4= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )? )
            {
            // InternalSTL.g:380:2: ( (kw= '-' | kw= '+' )? (this_INT_2= RULE_INT )? kw= '.' this_INT_4= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )? )
            // InternalSTL.g:381:3: (kw= '-' | kw= '+' )? (this_INT_2= RULE_INT )? kw= '.' this_INT_4= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )?
            {
            // InternalSTL.g:381:3: (kw= '-' | kw= '+' )?
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            else if ( (LA4_0==21) ) {
                alt4=2;
            }
            switch (alt4) {
                case 1 :
                    // InternalSTL.g:382:4: kw= '-'
                    {
                    kw=(Token)match(input,20,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalSTL.g:388:4: kw= '+'
                    {
                    kw=(Token)match(input,21,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getEDoubleAccess().getPlusSignKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            // InternalSTL.g:394:3: (this_INT_2= RULE_INT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSTL.g:395:4: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_INT_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INT_2, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
                      			
                    }

                    }
                    break;

            }

            kw=(Token)match(input,22,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2());
              		
            }
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_INT_4);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_INT_4, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3());
              		
            }
            // InternalSTL.g:415:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=23 && LA8_0<=24)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalSTL.g:416:4: (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT
                    {
                    // InternalSTL.g:416:4: (kw= 'E' | kw= 'e' )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==23) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==24) ) {
                        alt6=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalSTL.g:417:5: kw= 'E'
                            {
                            kw=(Token)match(input,23,FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalSTL.g:423:5: kw= 'e'
                            {
                            kw=(Token)match(input,24,FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalSTL.g:429:4: (kw= '-' | kw= '+' )?
                    int alt7=3;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==20) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==21) ) {
                        alt7=2;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalSTL.g:430:5: kw= '-'
                            {
                            kw=(Token)match(input,20,FOLLOW_16); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalSTL.g:436:5: kw= '+'
                            {
                            kw=(Token)match(input,21,FOLLOW_16); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getEDoubleAccess().getPlusSignKeyword_4_1_1());
                              				
                            }

                            }
                            break;

                    }

                    this_INT_9=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_INT_9);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INT_9, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEDouble"


    // $ANTLR start "entryRuleELine"
    // InternalSTL.g:454:1: entryRuleELine returns [String current=null] : iv_ruleELine= ruleELine EOF ;
    public final String entryRuleELine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleELine = null;


        try {
            // InternalSTL.g:454:45: (iv_ruleELine= ruleELine EOF )
            // InternalSTL.g:455:2: iv_ruleELine= ruleELine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getELineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleELine=ruleELine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleELine.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleELine"


    // $ANTLR start "ruleELine"
    // InternalSTL.g:461:1: ruleELine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( ( '\\r' | '\\n' )=> ( (kw= '\\r' )? | kw= '\\n' ) ) ) ) ;
    public final AntlrDatatypeRuleToken ruleELine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalSTL.g:467:2: ( (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( ( '\\r' | '\\n' )=> ( (kw= '\\r' )? | kw= '\\n' ) ) ) ) )
            // InternalSTL.g:468:2: (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( ( '\\r' | '\\n' )=> ( (kw= '\\r' )? | kw= '\\n' ) ) ) )
            {
            // InternalSTL.g:468:2: (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( ( '\\r' | '\\n' )=> ( (kw= '\\r' )? | kw= '\\n' ) ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_STRING) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_ID) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalSTL.g:469:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_STRING_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_STRING_0, grammarAccess.getELineAccess().getSTRINGTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSTL.g:477:3: (this_ID_1= RULE_ID ( ( '\\r' | '\\n' )=> ( (kw= '\\r' )? | kw= '\\n' ) ) )
                    {
                    // InternalSTL.g:477:3: (this_ID_1= RULE_ID ( ( '\\r' | '\\n' )=> ( (kw= '\\r' )? | kw= '\\n' ) ) )
                    // InternalSTL.g:478:4: this_ID_1= RULE_ID ( ( '\\r' | '\\n' )=> ( (kw= '\\r' )? | kw= '\\n' ) )
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_ID_1);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ID_1, grammarAccess.getELineAccess().getIDTerminalRuleCall_1_0());
                      			
                    }
                    // InternalSTL.g:485:4: ( ( '\\r' | '\\n' )=> ( (kw= '\\r' )? | kw= '\\n' ) )
                    // InternalSTL.g:486:5: ( '\\r' | '\\n' )=> ( (kw= '\\r' )? | kw= '\\n' )
                    {
                    // InternalSTL.g:487:5: ( (kw= '\\r' )? | kw= '\\n' )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==EOF||(LA10_0>=12 && LA10_0<=13)||LA10_0==25) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==26) ) {
                        alt10=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalSTL.g:488:6: (kw= '\\r' )?
                            {
                            // InternalSTL.g:488:6: (kw= '\\r' )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( (LA9_0==25) ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // InternalSTL.g:489:7: kw= '\\r'
                                    {
                                    kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							current.merge(kw);
                                      							newLeafNode(kw, grammarAccess.getELineAccess().getControl000dKeyword_1_1_0_0());
                                      						
                                    }

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // InternalSTL.g:496:6: kw= '\\n'
                            {
                            kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						current.merge(kw);
                              						newLeafNode(kw, grammarAccess.getELineAccess().getControl000aKeyword_1_1_0_1());
                              					
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleELine"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000003060L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000700010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000300010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000006000002L});

}