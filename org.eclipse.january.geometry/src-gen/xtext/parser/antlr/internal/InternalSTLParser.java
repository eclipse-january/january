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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'solid'", "'\\n'", "'endsolid'", "'facet'", "'normal'", "'outer'", "'loop'", "'vertex'", "'endloop'", "'endfacet'", "'-'", "'+'", "'.'", "'E'", "'e'"
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
             newCompositeNode(grammarAccess.getGeometryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGeometry=ruleGeometry();

            state._fsp--;

             current =iv_ruleGeometry; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalSTL.g:79:1: ruleGeometry returns [EObject current=null] : ( () otherlv_1= 'solid' ( (lv_name_2_0= ruleEString ) )? ( (lv_nodes_3_0= ruleShape_Impl ) ) (otherlv_4= '\\n' )? otherlv_5= 'endsolid' ( ruleEString )? ) ;
    public final EObject ruleGeometry() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_nodes_3_0 = null;



        	enterRule();

        try {
            // InternalSTL.g:85:2: ( ( () otherlv_1= 'solid' ( (lv_name_2_0= ruleEString ) )? ( (lv_nodes_3_0= ruleShape_Impl ) ) (otherlv_4= '\\n' )? otherlv_5= 'endsolid' ( ruleEString )? ) )
            // InternalSTL.g:86:2: ( () otherlv_1= 'solid' ( (lv_name_2_0= ruleEString ) )? ( (lv_nodes_3_0= ruleShape_Impl ) ) (otherlv_4= '\\n' )? otherlv_5= 'endsolid' ( ruleEString )? )
            {
            // InternalSTL.g:86:2: ( () otherlv_1= 'solid' ( (lv_name_2_0= ruleEString ) )? ( (lv_nodes_3_0= ruleShape_Impl ) ) (otherlv_4= '\\n' )? otherlv_5= 'endsolid' ( ruleEString )? )
            // InternalSTL.g:87:3: () otherlv_1= 'solid' ( (lv_name_2_0= ruleEString ) )? ( (lv_nodes_3_0= ruleShape_Impl ) ) (otherlv_4= '\\n' )? otherlv_5= 'endsolid' ( ruleEString )?
            {
            // InternalSTL.g:87:3: ()
            // InternalSTL.g:88:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGeometryAccess().getGeometryAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getGeometryAccess().getSolidKeyword_1());
            		
            // InternalSTL.g:98:3: ( (lv_name_2_0= ruleEString ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalSTL.g:99:4: (lv_name_2_0= ruleEString )
                    {
                    // InternalSTL.g:99:4: (lv_name_2_0= ruleEString )
                    // InternalSTL.g:100:5: lv_name_2_0= ruleEString
                    {

                    					newCompositeNode(grammarAccess.getGeometryAccess().getNameEStringParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_4);
                    lv_name_2_0=ruleEString();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getGeometryRule());
                    					}
                    					set(
                    						current,
                    						"name",
                    						lv_name_2_0,
                    						"xtext.STL.EString");
                    					afterParserOrEnumRuleCall();
                    				

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

            					newCompositeNode(grammarAccess.getGeometryAccess().getNodesShape_ImplParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_5);
            lv_nodes_3_0=ruleShape_Impl();

            state._fsp--;


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

            // InternalSTL.g:136:3: (otherlv_4= '\\n' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalSTL.g:137:4: otherlv_4= '\\n'
                    {
                    otherlv_4=(Token)match(input,12,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getGeometryAccess().getControl000aKeyword_4());
                    			

                    }
                    break;

            }

            otherlv_5=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getGeometryAccess().getEndsolidKeyword_5());
            		
            // InternalSTL.g:146:3: ( ruleEString )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_ID)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalSTL.g:147:4: ruleEString
                    {

                    				newCompositeNode(grammarAccess.getGeometryAccess().getEStringParserRuleCall_6());
                    			
                    pushFollow(FOLLOW_2);
                    ruleEString();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalSTL.g:159:1: entryRuleShape_Impl returns [EObject current=null] : iv_ruleShape_Impl= ruleShape_Impl EOF ;
    public final EObject entryRuleShape_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShape_Impl = null;


        try {
            // InternalSTL.g:159:51: (iv_ruleShape_Impl= ruleShape_Impl EOF )
            // InternalSTL.g:160:2: iv_ruleShape_Impl= ruleShape_Impl EOF
            {
             newCompositeNode(grammarAccess.getShape_ImplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleShape_Impl=ruleShape_Impl();

            state._fsp--;

             current =iv_ruleShape_Impl; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalSTL.g:166:1: ruleShape_Impl returns [EObject current=null] : ( () ( (lv_triangles_1_0= ruleTriangle ) )* ) ;
    public final EObject ruleShape_Impl() throws RecognitionException {
        EObject current = null;

        EObject lv_triangles_1_0 = null;



        	enterRule();

        try {
            // InternalSTL.g:172:2: ( ( () ( (lv_triangles_1_0= ruleTriangle ) )* ) )
            // InternalSTL.g:173:2: ( () ( (lv_triangles_1_0= ruleTriangle ) )* )
            {
            // InternalSTL.g:173:2: ( () ( (lv_triangles_1_0= ruleTriangle ) )* )
            // InternalSTL.g:174:3: () ( (lv_triangles_1_0= ruleTriangle ) )*
            {
            // InternalSTL.g:174:3: ()
            // InternalSTL.g:175:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getShape_ImplAccess().getShapeAction_0(),
            					current);
            			

            }

            // InternalSTL.g:181:3: ( (lv_triangles_1_0= ruleTriangle ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalSTL.g:182:4: (lv_triangles_1_0= ruleTriangle )
            	    {
            	    // InternalSTL.g:182:4: (lv_triangles_1_0= ruleTriangle )
            	    // InternalSTL.g:183:5: lv_triangles_1_0= ruleTriangle
            	    {

            	    					newCompositeNode(grammarAccess.getShape_ImplAccess().getTrianglesTriangleParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_triangles_1_0=ruleTriangle();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }


            	leaveRule();

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
    // InternalSTL.g:204:1: entryRuleTriangle returns [EObject current=null] : iv_ruleTriangle= ruleTriangle EOF ;
    public final EObject entryRuleTriangle() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriangle = null;


        try {
            // InternalSTL.g:204:49: (iv_ruleTriangle= ruleTriangle EOF )
            // InternalSTL.g:205:2: iv_ruleTriangle= ruleTriangle EOF
            {
             newCompositeNode(grammarAccess.getTriangleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTriangle=ruleTriangle();

            state._fsp--;

             current =iv_ruleTriangle; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalSTL.g:211:1: ruleTriangle returns [EObject current=null] : ( () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )* otherlv_8= 'endloop' otherlv_9= 'endfacet' ) ;
    public final EObject ruleTriangle() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_normal_3_0 = null;

        EObject lv_vertices_7_0 = null;



        	enterRule();

        try {
            // InternalSTL.g:217:2: ( ( () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )* otherlv_8= 'endloop' otherlv_9= 'endfacet' ) )
            // InternalSTL.g:218:2: ( () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )* otherlv_8= 'endloop' otherlv_9= 'endfacet' )
            {
            // InternalSTL.g:218:2: ( () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )* otherlv_8= 'endloop' otherlv_9= 'endfacet' )
            // InternalSTL.g:219:3: () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )* otherlv_8= 'endloop' otherlv_9= 'endfacet'
            {
            // InternalSTL.g:219:3: ()
            // InternalSTL.g:220:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTriangleAccess().getTriangleAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,14,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getTriangleAccess().getFacetKeyword_1());
            		
            // InternalSTL.g:230:3: (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) )
            // InternalSTL.g:231:4: otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) )
            {
            otherlv_2=(Token)match(input,15,FOLLOW_10); 

            				newLeafNode(otherlv_2, grammarAccess.getTriangleAccess().getNormalKeyword_2_0());
            			
            // InternalSTL.g:235:4: ( (lv_normal_3_0= ruleVertex ) )
            // InternalSTL.g:236:5: (lv_normal_3_0= ruleVertex )
            {
            // InternalSTL.g:236:5: (lv_normal_3_0= ruleVertex )
            // InternalSTL.g:237:6: lv_normal_3_0= ruleVertex
            {

            						newCompositeNode(grammarAccess.getTriangleAccess().getNormalVertexParserRuleCall_2_1_0());
            					
            pushFollow(FOLLOW_11);
            lv_normal_3_0=ruleVertex();

            state._fsp--;


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

            otherlv_4=(Token)match(input,16,FOLLOW_12); 

            			newLeafNode(otherlv_4, grammarAccess.getTriangleAccess().getOuterKeyword_3());
            		
            otherlv_5=(Token)match(input,17,FOLLOW_13); 

            			newLeafNode(otherlv_5, grammarAccess.getTriangleAccess().getLoopKeyword_4());
            		
            // InternalSTL.g:263:3: (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalSTL.g:264:4: otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) )
            	    {
            	    otherlv_6=(Token)match(input,18,FOLLOW_10); 

            	    				newLeafNode(otherlv_6, grammarAccess.getTriangleAccess().getVertexKeyword_5_0());
            	    			
            	    // InternalSTL.g:268:4: ( (lv_vertices_7_0= ruleVertex ) )
            	    // InternalSTL.g:269:5: (lv_vertices_7_0= ruleVertex )
            	    {
            	    // InternalSTL.g:269:5: (lv_vertices_7_0= ruleVertex )
            	    // InternalSTL.g:270:6: lv_vertices_7_0= ruleVertex
            	    {

            	    						newCompositeNode(grammarAccess.getTriangleAccess().getVerticesVertexParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_vertices_7_0=ruleVertex();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTriangleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vertices",
            	    							lv_vertices_7_0,
            	    							"xtext.STL.Vertex");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_8=(Token)match(input,19,FOLLOW_14); 

            			newLeafNode(otherlv_8, grammarAccess.getTriangleAccess().getEndloopKeyword_6());
            		
            otherlv_9=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getTriangleAccess().getEndfacetKeyword_7());
            		

            }


            }


            	leaveRule();

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
    // InternalSTL.g:300:1: entryRuleVertex returns [EObject current=null] : iv_ruleVertex= ruleVertex EOF ;
    public final EObject entryRuleVertex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVertex = null;


        try {
            // InternalSTL.g:300:47: (iv_ruleVertex= ruleVertex EOF )
            // InternalSTL.g:301:2: iv_ruleVertex= ruleVertex EOF
            {
             newCompositeNode(grammarAccess.getVertexRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVertex=ruleVertex();

            state._fsp--;

             current =iv_ruleVertex; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalSTL.g:307:1: ruleVertex returns [EObject current=null] : ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) ) ;
    public final EObject ruleVertex() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_x_1_0 = null;

        AntlrDatatypeRuleToken lv_y_2_0 = null;

        AntlrDatatypeRuleToken lv_z_3_0 = null;



        	enterRule();

        try {
            // InternalSTL.g:313:2: ( ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) ) )
            // InternalSTL.g:314:2: ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) )
            {
            // InternalSTL.g:314:2: ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) )
            // InternalSTL.g:315:3: () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) )
            {
            // InternalSTL.g:315:3: ()
            // InternalSTL.g:316:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVertexAccess().getVertexAction_0(),
            					current);
            			

            }

            // InternalSTL.g:322:3: ( (lv_x_1_0= ruleEDouble ) )
            // InternalSTL.g:323:4: (lv_x_1_0= ruleEDouble )
            {
            // InternalSTL.g:323:4: (lv_x_1_0= ruleEDouble )
            // InternalSTL.g:324:5: lv_x_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getVertexAccess().getXEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_x_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVertexRule());
            					}
            					set(
            						current,
            						"x",
            						lv_x_1_0,
            						"xtext.STL.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSTL.g:341:3: ( (lv_y_2_0= ruleEDouble ) )
            // InternalSTL.g:342:4: (lv_y_2_0= ruleEDouble )
            {
            // InternalSTL.g:342:4: (lv_y_2_0= ruleEDouble )
            // InternalSTL.g:343:5: lv_y_2_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getVertexAccess().getYEDoubleParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_10);
            lv_y_2_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVertexRule());
            					}
            					set(
            						current,
            						"y",
            						lv_y_2_0,
            						"xtext.STL.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSTL.g:360:3: ( (lv_z_3_0= ruleEDouble ) )
            // InternalSTL.g:361:4: (lv_z_3_0= ruleEDouble )
            {
            // InternalSTL.g:361:4: (lv_z_3_0= ruleEDouble )
            // InternalSTL.g:362:5: lv_z_3_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getVertexAccess().getZEDoubleParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_z_3_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVertexRule());
            					}
            					set(
            						current,
            						"z",
            						lv_z_3_0,
            						"xtext.STL.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

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
    // InternalSTL.g:383:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalSTL.g:383:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalSTL.g:384:2: iv_ruleEDouble= ruleEDouble EOF
            {
             newCompositeNode(grammarAccess.getEDoubleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEDouble=ruleEDouble();

            state._fsp--;

             current =iv_ruleEDouble.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalSTL.g:390:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' | kw= '+' )? (this_INT_2= RULE_INT )? kw= '.' this_INT_4= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_9=null;


        	enterRule();

        try {
            // InternalSTL.g:396:2: ( ( (kw= '-' | kw= '+' )? (this_INT_2= RULE_INT )? kw= '.' this_INT_4= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )? ) )
            // InternalSTL.g:397:2: ( (kw= '-' | kw= '+' )? (this_INT_2= RULE_INT )? kw= '.' this_INT_4= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )? )
            {
            // InternalSTL.g:397:2: ( (kw= '-' | kw= '+' )? (this_INT_2= RULE_INT )? kw= '.' this_INT_4= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )? )
            // InternalSTL.g:398:3: (kw= '-' | kw= '+' )? (this_INT_2= RULE_INT )? kw= '.' this_INT_4= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )?
            {
            // InternalSTL.g:398:3: (kw= '-' | kw= '+' )?
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            else if ( (LA6_0==22) ) {
                alt6=2;
            }
            switch (alt6) {
                case 1 :
                    // InternalSTL.g:399:4: kw= '-'
                    {
                    kw=(Token)match(input,21,FOLLOW_15); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalSTL.g:405:4: kw= '+'
                    {
                    kw=(Token)match(input,22,FOLLOW_15); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getPlusSignKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalSTL.g:411:3: (this_INT_2= RULE_INT )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_INT) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalSTL.g:412:4: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_16); 

                    				current.merge(this_INT_2);
                    			

                    				newLeafNode(this_INT_2, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
                    			

                    }
                    break;

            }

            kw=(Token)match(input,23,FOLLOW_17); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2());
            		
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_18); 

            			current.merge(this_INT_4);
            		

            			newLeafNode(this_INT_4, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3());
            		
            // InternalSTL.g:432:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=24 && LA10_0<=25)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSTL.g:433:4: (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT
                    {
                    // InternalSTL.g:433:4: (kw= 'E' | kw= 'e' )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==24) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==25) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalSTL.g:434:5: kw= 'E'
                            {
                            kw=(Token)match(input,24,FOLLOW_19); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalSTL.g:440:5: kw= 'e'
                            {
                            kw=(Token)match(input,25,FOLLOW_19); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1());
                            				

                            }
                            break;

                    }

                    // InternalSTL.g:446:4: (kw= '-' | kw= '+' )?
                    int alt9=3;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==21) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==22) ) {
                        alt9=2;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalSTL.g:447:5: kw= '-'
                            {
                            kw=(Token)match(input,21,FOLLOW_17); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalSTL.g:453:5: kw= '+'
                            {
                            kw=(Token)match(input,22,FOLLOW_17); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getPlusSignKeyword_4_1_1());
                            				

                            }
                            break;

                    }

                    this_INT_9=(Token)match(input,RULE_INT,FOLLOW_2); 

                    				current.merge(this_INT_9);
                    			

                    				newLeafNode(this_INT_9, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleEString"
    // InternalSTL.g:471:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalSTL.g:471:47: (iv_ruleEString= ruleEString EOF )
            // InternalSTL.g:472:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalSTL.g:478:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalSTL.g:484:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalSTL.g:485:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalSTL.g:485:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_STRING) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_ID) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalSTL.g:486:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSTL.g:494:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000007060L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000007000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000E00010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000600010L});

}