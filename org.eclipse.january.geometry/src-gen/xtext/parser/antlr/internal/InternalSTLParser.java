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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_WS", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'solid'", "'endsolid'", "'facet'", "'normal'", "'outer'", "'loop'", "'vertex'", "'endloop'", "'endfacet'", "'-'", "'+'", "'.'", "'E'", "'e'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=9;
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
    public static final int RULE_ID=4;
    public static final int RULE_WS=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=7;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
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
    // InternalSTL.g:79:1: ruleGeometry returns [EObject current=null] : ( () ( (lv_nodes_1_0= ruleShape_Impl ) )* ) ;
    public final EObject ruleGeometry() throws RecognitionException {
        EObject current = null;

        EObject lv_nodes_1_0 = null;



        	enterRule();

        try {
            // InternalSTL.g:85:2: ( ( () ( (lv_nodes_1_0= ruleShape_Impl ) )* ) )
            // InternalSTL.g:86:2: ( () ( (lv_nodes_1_0= ruleShape_Impl ) )* )
            {
            // InternalSTL.g:86:2: ( () ( (lv_nodes_1_0= ruleShape_Impl ) )* )
            // InternalSTL.g:87:3: () ( (lv_nodes_1_0= ruleShape_Impl ) )*
            {
            // InternalSTL.g:87:3: ()
            // InternalSTL.g:88:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGeometryAccess().getGeometryAction_0(),
            					current);
            			

            }

            // InternalSTL.g:94:3: ( (lv_nodes_1_0= ruleShape_Impl ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSTL.g:95:4: (lv_nodes_1_0= ruleShape_Impl )
            	    {
            	    // InternalSTL.g:95:4: (lv_nodes_1_0= ruleShape_Impl )
            	    // InternalSTL.g:96:5: lv_nodes_1_0= ruleShape_Impl
            	    {

            	    					newCompositeNode(grammarAccess.getGeometryAccess().getNodesShape_ImplParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_nodes_1_0=ruleShape_Impl();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGeometryRule());
            	    					}
            	    					add(
            	    						current,
            	    						"nodes",
            	    						lv_nodes_1_0,
            	    						"xtext.STL.Shape_Impl");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end "ruleGeometry"


    // $ANTLR start "entryRuleShape_Impl"
    // InternalSTL.g:117:1: entryRuleShape_Impl returns [EObject current=null] : iv_ruleShape_Impl= ruleShape_Impl EOF ;
    public final EObject entryRuleShape_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShape_Impl = null;


        try {
            // InternalSTL.g:117:51: (iv_ruleShape_Impl= ruleShape_Impl EOF )
            // InternalSTL.g:118:2: iv_ruleShape_Impl= ruleShape_Impl EOF
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
    // InternalSTL.g:124:1: ruleShape_Impl returns [EObject current=null] : ( () otherlv_1= 'solid' ( (lv_name_2_0= ruleEString ) )? (this_ID_3= RULE_ID | this_WS_4= RULE_WS | this_STRING_5= RULE_STRING | this_INT_6= RULE_INT )* ( (lv_triangles_7_0= ruleTriangle ) )* (this_WS_8= RULE_WS )* otherlv_9= 'endsolid' ( ruleEString )? (this_ID_11= RULE_ID | this_WS_12= RULE_WS | this_STRING_13= RULE_STRING | this_INT_14= RULE_INT )* ) ;
    public final EObject ruleShape_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_ID_3=null;
        Token this_WS_4=null;
        Token this_STRING_5=null;
        Token this_INT_6=null;
        Token this_WS_8=null;
        Token otherlv_9=null;
        Token this_ID_11=null;
        Token this_WS_12=null;
        Token this_STRING_13=null;
        Token this_INT_14=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_triangles_7_0 = null;



        	enterRule();

        try {
            // InternalSTL.g:130:2: ( ( () otherlv_1= 'solid' ( (lv_name_2_0= ruleEString ) )? (this_ID_3= RULE_ID | this_WS_4= RULE_WS | this_STRING_5= RULE_STRING | this_INT_6= RULE_INT )* ( (lv_triangles_7_0= ruleTriangle ) )* (this_WS_8= RULE_WS )* otherlv_9= 'endsolid' ( ruleEString )? (this_ID_11= RULE_ID | this_WS_12= RULE_WS | this_STRING_13= RULE_STRING | this_INT_14= RULE_INT )* ) )
            // InternalSTL.g:131:2: ( () otherlv_1= 'solid' ( (lv_name_2_0= ruleEString ) )? (this_ID_3= RULE_ID | this_WS_4= RULE_WS | this_STRING_5= RULE_STRING | this_INT_6= RULE_INT )* ( (lv_triangles_7_0= ruleTriangle ) )* (this_WS_8= RULE_WS )* otherlv_9= 'endsolid' ( ruleEString )? (this_ID_11= RULE_ID | this_WS_12= RULE_WS | this_STRING_13= RULE_STRING | this_INT_14= RULE_INT )* )
            {
            // InternalSTL.g:131:2: ( () otherlv_1= 'solid' ( (lv_name_2_0= ruleEString ) )? (this_ID_3= RULE_ID | this_WS_4= RULE_WS | this_STRING_5= RULE_STRING | this_INT_6= RULE_INT )* ( (lv_triangles_7_0= ruleTriangle ) )* (this_WS_8= RULE_WS )* otherlv_9= 'endsolid' ( ruleEString )? (this_ID_11= RULE_ID | this_WS_12= RULE_WS | this_STRING_13= RULE_STRING | this_INT_14= RULE_INT )* )
            // InternalSTL.g:132:3: () otherlv_1= 'solid' ( (lv_name_2_0= ruleEString ) )? (this_ID_3= RULE_ID | this_WS_4= RULE_WS | this_STRING_5= RULE_STRING | this_INT_6= RULE_INT )* ( (lv_triangles_7_0= ruleTriangle ) )* (this_WS_8= RULE_WS )* otherlv_9= 'endsolid' ( ruleEString )? (this_ID_11= RULE_ID | this_WS_12= RULE_WS | this_STRING_13= RULE_STRING | this_INT_14= RULE_INT )*
            {
            // InternalSTL.g:132:3: ()
            // InternalSTL.g:133:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getShape_ImplAccess().getShapeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getShape_ImplAccess().getSolidKeyword_1());
            		
            // InternalSTL.g:143:3: ( (lv_name_2_0= ruleEString ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalSTL.g:144:4: (lv_name_2_0= ruleEString )
                    {
                    // InternalSTL.g:144:4: (lv_name_2_0= ruleEString )
                    // InternalSTL.g:145:5: lv_name_2_0= ruleEString
                    {

                    					newCompositeNode(grammarAccess.getShape_ImplAccess().getNameEStringParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_4);
                    lv_name_2_0=ruleEString();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getShape_ImplRule());
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

            // InternalSTL.g:162:3: (this_ID_3= RULE_ID | this_WS_4= RULE_WS | this_STRING_5= RULE_STRING | this_INT_6= RULE_INT )*
            loop3:
            do {
                int alt3=5;
                switch ( input.LA(1) ) {
                case RULE_WS:
                    {
                    alt3=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt3=1;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt3=3;
                    }
                    break;
                case RULE_INT:
                    {
                    alt3=4;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // InternalSTL.g:163:4: this_ID_3= RULE_ID
            	    {
            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_4); 

            	    				newLeafNode(this_ID_3, grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_3_0());
            	    			

            	    }
            	    break;
            	case 2 :
            	    // InternalSTL.g:168:4: this_WS_4= RULE_WS
            	    {
            	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_4); 

            	    				newLeafNode(this_WS_4, grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_3_1());
            	    			

            	    }
            	    break;
            	case 3 :
            	    // InternalSTL.g:173:4: this_STRING_5= RULE_STRING
            	    {
            	    this_STRING_5=(Token)match(input,RULE_STRING,FOLLOW_4); 

            	    				newLeafNode(this_STRING_5, grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_3_2());
            	    			

            	    }
            	    break;
            	case 4 :
            	    // InternalSTL.g:178:4: this_INT_6= RULE_INT
            	    {
            	    this_INT_6=(Token)match(input,RULE_INT,FOLLOW_4); 

            	    				newLeafNode(this_INT_6, grammarAccess.getShape_ImplAccess().getINTTerminalRuleCall_3_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalSTL.g:183:3: ( (lv_triangles_7_0= ruleTriangle ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalSTL.g:184:4: (lv_triangles_7_0= ruleTriangle )
            	    {
            	    // InternalSTL.g:184:4: (lv_triangles_7_0= ruleTriangle )
            	    // InternalSTL.g:185:5: lv_triangles_7_0= ruleTriangle
            	    {

            	    					newCompositeNode(grammarAccess.getShape_ImplAccess().getTrianglesTriangleParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_triangles_7_0=ruleTriangle();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getShape_ImplRule());
            	    					}
            	    					add(
            	    						current,
            	    						"triangles",
            	    						lv_triangles_7_0,
            	    						"xtext.STL.Triangle");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalSTL.g:202:3: (this_WS_8= RULE_WS )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_WS) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalSTL.g:203:4: this_WS_8= RULE_WS
            	    {
            	    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_6); 

            	    				newLeafNode(this_WS_8, grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_5());
            	    			

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_9=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_9, grammarAccess.getShape_ImplAccess().getEndsolidKeyword_6());
            		
            // InternalSTL.g:212:3: ( ruleEString )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalSTL.g:213:4: ruleEString
                    {

                    				newCompositeNode(grammarAccess.getShape_ImplAccess().getEStringParserRuleCall_7());
                    			
                    pushFollow(FOLLOW_7);
                    ruleEString();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalSTL.g:221:3: (this_ID_11= RULE_ID | this_WS_12= RULE_WS | this_STRING_13= RULE_STRING | this_INT_14= RULE_INT )*
            loop7:
            do {
                int alt7=5;
                switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt7=1;
                    }
                    break;
                case RULE_WS:
                    {
                    alt7=2;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt7=3;
                    }
                    break;
                case RULE_INT:
                    {
                    alt7=4;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // InternalSTL.g:222:4: this_ID_11= RULE_ID
            	    {
            	    this_ID_11=(Token)match(input,RULE_ID,FOLLOW_7); 

            	    				newLeafNode(this_ID_11, grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_8_0());
            	    			

            	    }
            	    break;
            	case 2 :
            	    // InternalSTL.g:227:4: this_WS_12= RULE_WS
            	    {
            	    this_WS_12=(Token)match(input,RULE_WS,FOLLOW_7); 

            	    				newLeafNode(this_WS_12, grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_8_1());
            	    			

            	    }
            	    break;
            	case 3 :
            	    // InternalSTL.g:232:4: this_STRING_13= RULE_STRING
            	    {
            	    this_STRING_13=(Token)match(input,RULE_STRING,FOLLOW_7); 

            	    				newLeafNode(this_STRING_13, grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_8_2());
            	    			

            	    }
            	    break;
            	case 4 :
            	    // InternalSTL.g:237:4: this_INT_14= RULE_INT
            	    {
            	    this_INT_14=(Token)match(input,RULE_INT,FOLLOW_7); 

            	    				newLeafNode(this_INT_14, grammarAccess.getShape_ImplAccess().getINTTerminalRuleCall_8_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // InternalSTL.g:246:1: entryRuleTriangle returns [EObject current=null] : iv_ruleTriangle= ruleTriangle EOF ;
    public final EObject entryRuleTriangle() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriangle = null;


        try {
            // InternalSTL.g:246:49: (iv_ruleTriangle= ruleTriangle EOF )
            // InternalSTL.g:247:2: iv_ruleTriangle= ruleTriangle EOF
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
    // InternalSTL.g:253:1: ruleTriangle returns [EObject current=null] : ( () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )* otherlv_8= 'endloop' otherlv_9= 'endfacet' ) ;
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
            // InternalSTL.g:259:2: ( ( () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )* otherlv_8= 'endloop' otherlv_9= 'endfacet' ) )
            // InternalSTL.g:260:2: ( () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )* otherlv_8= 'endloop' otherlv_9= 'endfacet' )
            {
            // InternalSTL.g:260:2: ( () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )* otherlv_8= 'endloop' otherlv_9= 'endfacet' )
            // InternalSTL.g:261:3: () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )* otherlv_8= 'endloop' otherlv_9= 'endfacet'
            {
            // InternalSTL.g:261:3: ()
            // InternalSTL.g:262:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTriangleAccess().getTriangleAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getTriangleAccess().getFacetKeyword_1());
            		
            // InternalSTL.g:272:3: (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) )
            // InternalSTL.g:273:4: otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) )
            {
            otherlv_2=(Token)match(input,14,FOLLOW_9); 

            				newLeafNode(otherlv_2, grammarAccess.getTriangleAccess().getNormalKeyword_2_0());
            			
            // InternalSTL.g:277:4: ( (lv_normal_3_0= ruleVertex ) )
            // InternalSTL.g:278:5: (lv_normal_3_0= ruleVertex )
            {
            // InternalSTL.g:278:5: (lv_normal_3_0= ruleVertex )
            // InternalSTL.g:279:6: lv_normal_3_0= ruleVertex
            {

            						newCompositeNode(grammarAccess.getTriangleAccess().getNormalVertexParserRuleCall_2_1_0());
            					
            pushFollow(FOLLOW_10);
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

            otherlv_4=(Token)match(input,15,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getTriangleAccess().getOuterKeyword_3());
            		
            otherlv_5=(Token)match(input,16,FOLLOW_12); 

            			newLeafNode(otherlv_5, grammarAccess.getTriangleAccess().getLoopKeyword_4());
            		
            // InternalSTL.g:305:3: (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalSTL.g:306:4: otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) )
            	    {
            	    otherlv_6=(Token)match(input,17,FOLLOW_9); 

            	    				newLeafNode(otherlv_6, grammarAccess.getTriangleAccess().getVertexKeyword_5_0());
            	    			
            	    // InternalSTL.g:310:4: ( (lv_vertices_7_0= ruleVertex ) )
            	    // InternalSTL.g:311:5: (lv_vertices_7_0= ruleVertex )
            	    {
            	    // InternalSTL.g:311:5: (lv_vertices_7_0= ruleVertex )
            	    // InternalSTL.g:312:6: lv_vertices_7_0= ruleVertex
            	    {

            	    						newCompositeNode(grammarAccess.getTriangleAccess().getVerticesVertexParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_12);
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
            	    break loop8;
                }
            } while (true);

            otherlv_8=(Token)match(input,18,FOLLOW_13); 

            			newLeafNode(otherlv_8, grammarAccess.getTriangleAccess().getEndloopKeyword_6());
            		
            otherlv_9=(Token)match(input,19,FOLLOW_2); 

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
    // InternalSTL.g:342:1: entryRuleVertex returns [EObject current=null] : iv_ruleVertex= ruleVertex EOF ;
    public final EObject entryRuleVertex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVertex = null;


        try {
            // InternalSTL.g:342:47: (iv_ruleVertex= ruleVertex EOF )
            // InternalSTL.g:343:2: iv_ruleVertex= ruleVertex EOF
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
    // InternalSTL.g:349:1: ruleVertex returns [EObject current=null] : ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) ) ;
    public final EObject ruleVertex() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_x_1_0 = null;

        AntlrDatatypeRuleToken lv_y_2_0 = null;

        AntlrDatatypeRuleToken lv_z_3_0 = null;



        	enterRule();

        try {
            // InternalSTL.g:355:2: ( ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) ) )
            // InternalSTL.g:356:2: ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) )
            {
            // InternalSTL.g:356:2: ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) )
            // InternalSTL.g:357:3: () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) )
            {
            // InternalSTL.g:357:3: ()
            // InternalSTL.g:358:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVertexAccess().getVertexAction_0(),
            					current);
            			

            }

            // InternalSTL.g:364:3: ( (lv_x_1_0= ruleEDouble ) )
            // InternalSTL.g:365:4: (lv_x_1_0= ruleEDouble )
            {
            // InternalSTL.g:365:4: (lv_x_1_0= ruleEDouble )
            // InternalSTL.g:366:5: lv_x_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getVertexAccess().getXEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_9);
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

            // InternalSTL.g:383:3: ( (lv_y_2_0= ruleEDouble ) )
            // InternalSTL.g:384:4: (lv_y_2_0= ruleEDouble )
            {
            // InternalSTL.g:384:4: (lv_y_2_0= ruleEDouble )
            // InternalSTL.g:385:5: lv_y_2_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getVertexAccess().getYEDoubleParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_9);
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

            // InternalSTL.g:402:3: ( (lv_z_3_0= ruleEDouble ) )
            // InternalSTL.g:403:4: (lv_z_3_0= ruleEDouble )
            {
            // InternalSTL.g:403:4: (lv_z_3_0= ruleEDouble )
            // InternalSTL.g:404:5: lv_z_3_0= ruleEDouble
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
    // InternalSTL.g:425:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalSTL.g:425:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalSTL.g:426:2: iv_ruleEDouble= ruleEDouble EOF
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
    // InternalSTL.g:432:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' | kw= '+' )? (this_INT_2= RULE_INT )? kw= '.' this_INT_4= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_9=null;


        	enterRule();

        try {
            // InternalSTL.g:438:2: ( ( (kw= '-' | kw= '+' )? (this_INT_2= RULE_INT )? kw= '.' this_INT_4= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )? ) )
            // InternalSTL.g:439:2: ( (kw= '-' | kw= '+' )? (this_INT_2= RULE_INT )? kw= '.' this_INT_4= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )? )
            {
            // InternalSTL.g:439:2: ( (kw= '-' | kw= '+' )? (this_INT_2= RULE_INT )? kw= '.' this_INT_4= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )? )
            // InternalSTL.g:440:3: (kw= '-' | kw= '+' )? (this_INT_2= RULE_INT )? kw= '.' this_INT_4= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )?
            {
            // InternalSTL.g:440:3: (kw= '-' | kw= '+' )?
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            else if ( (LA9_0==21) ) {
                alt9=2;
            }
            switch (alt9) {
                case 1 :
                    // InternalSTL.g:441:4: kw= '-'
                    {
                    kw=(Token)match(input,20,FOLLOW_14); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalSTL.g:447:4: kw= '+'
                    {
                    kw=(Token)match(input,21,FOLLOW_14); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getPlusSignKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalSTL.g:453:3: (this_INT_2= RULE_INT )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_INT) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSTL.g:454:4: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_15); 

                    				current.merge(this_INT_2);
                    			

                    				newLeafNode(this_INT_2, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
                    			

                    }
                    break;

            }

            kw=(Token)match(input,22,FOLLOW_16); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2());
            		
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_17); 

            			current.merge(this_INT_4);
            		

            			newLeafNode(this_INT_4, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3());
            		
            // InternalSTL.g:474:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=23 && LA13_0<=24)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalSTL.g:475:4: (kw= 'E' | kw= 'e' ) (kw= '-' | kw= '+' )? this_INT_9= RULE_INT
                    {
                    // InternalSTL.g:475:4: (kw= 'E' | kw= 'e' )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==23) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==24) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalSTL.g:476:5: kw= 'E'
                            {
                            kw=(Token)match(input,23,FOLLOW_18); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalSTL.g:482:5: kw= 'e'
                            {
                            kw=(Token)match(input,24,FOLLOW_18); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1());
                            				

                            }
                            break;

                    }

                    // InternalSTL.g:488:4: (kw= '-' | kw= '+' )?
                    int alt12=3;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==20) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==21) ) {
                        alt12=2;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalSTL.g:489:5: kw= '-'
                            {
                            kw=(Token)match(input,20,FOLLOW_16); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalSTL.g:495:5: kw= '+'
                            {
                            kw=(Token)match(input,21,FOLLOW_16); 

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
    // InternalSTL.g:513:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalSTL.g:513:47: (iv_ruleEString= ruleEString EOF )
            // InternalSTL.g:514:2: iv_ruleEString= ruleEString EOF
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
    // InternalSTL.g:520:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalSTL.g:526:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalSTL.g:527:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalSTL.g:527:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_STRING) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_ID) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalSTL.g:528:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSTL.g:536:3: this_ID_1= RULE_ID
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000000030F0L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000003020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000000000F2L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000700080L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400080L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000300080L});

}