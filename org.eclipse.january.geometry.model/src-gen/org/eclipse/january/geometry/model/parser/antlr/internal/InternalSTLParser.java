package org.eclipse.january.geometry.model.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.january.geometry.model.services.STLGrammarAccess;



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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_WS", "RULE_STRING", "RULE_DOUBLE", "RULE_ANY_OTHER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "'solid'", "'endsolid'", "'facet'", "'normal'", "'outer'", "'loop'", "'vertex'", "'endloop'", "'endfacet'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int RULE_DOUBLE=7;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=5;
    public static final int RULE_ANY_OTHER=8;
    public static final int RULE_INT=9;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__20=20;

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

                if ( (LA1_0==12) ) {
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
            	    						"org.eclipse.january.geometry.model.STL.Shape_Impl");
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
    // InternalSTL.g:124:1: ruleShape_Impl returns [EObject current=null] : ( () otherlv_1= 'solid' ( (lv_name_2_0= ruleEString ) )? (this_ID_3= RULE_ID | this_WS_4= RULE_WS | this_STRING_5= RULE_STRING | this_DOUBLE_6= RULE_DOUBLE | this_ANY_OTHER_7= RULE_ANY_OTHER )* ( (lv_triangles_8_0= ruleTriangle ) )* (this_WS_9= RULE_WS )* otherlv_10= 'endsolid' ( ruleEString )? (this_ID_12= RULE_ID | this_WS_13= RULE_WS | this_STRING_14= RULE_STRING | this_DOUBLE_15= RULE_DOUBLE | this_ANY_OTHER_16= RULE_ANY_OTHER )* ) ;
    public final EObject ruleShape_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_ID_3=null;
        Token this_WS_4=null;
        Token this_STRING_5=null;
        Token this_DOUBLE_6=null;
        Token this_ANY_OTHER_7=null;
        Token this_WS_9=null;
        Token otherlv_10=null;
        Token this_ID_12=null;
        Token this_WS_13=null;
        Token this_STRING_14=null;
        Token this_DOUBLE_15=null;
        Token this_ANY_OTHER_16=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_triangles_8_0 = null;



        	enterRule();

        try {
            // InternalSTL.g:130:2: ( ( () otherlv_1= 'solid' ( (lv_name_2_0= ruleEString ) )? (this_ID_3= RULE_ID | this_WS_4= RULE_WS | this_STRING_5= RULE_STRING | this_DOUBLE_6= RULE_DOUBLE | this_ANY_OTHER_7= RULE_ANY_OTHER )* ( (lv_triangles_8_0= ruleTriangle ) )* (this_WS_9= RULE_WS )* otherlv_10= 'endsolid' ( ruleEString )? (this_ID_12= RULE_ID | this_WS_13= RULE_WS | this_STRING_14= RULE_STRING | this_DOUBLE_15= RULE_DOUBLE | this_ANY_OTHER_16= RULE_ANY_OTHER )* ) )
            // InternalSTL.g:131:2: ( () otherlv_1= 'solid' ( (lv_name_2_0= ruleEString ) )? (this_ID_3= RULE_ID | this_WS_4= RULE_WS | this_STRING_5= RULE_STRING | this_DOUBLE_6= RULE_DOUBLE | this_ANY_OTHER_7= RULE_ANY_OTHER )* ( (lv_triangles_8_0= ruleTriangle ) )* (this_WS_9= RULE_WS )* otherlv_10= 'endsolid' ( ruleEString )? (this_ID_12= RULE_ID | this_WS_13= RULE_WS | this_STRING_14= RULE_STRING | this_DOUBLE_15= RULE_DOUBLE | this_ANY_OTHER_16= RULE_ANY_OTHER )* )
            {
            // InternalSTL.g:131:2: ( () otherlv_1= 'solid' ( (lv_name_2_0= ruleEString ) )? (this_ID_3= RULE_ID | this_WS_4= RULE_WS | this_STRING_5= RULE_STRING | this_DOUBLE_6= RULE_DOUBLE | this_ANY_OTHER_7= RULE_ANY_OTHER )* ( (lv_triangles_8_0= ruleTriangle ) )* (this_WS_9= RULE_WS )* otherlv_10= 'endsolid' ( ruleEString )? (this_ID_12= RULE_ID | this_WS_13= RULE_WS | this_STRING_14= RULE_STRING | this_DOUBLE_15= RULE_DOUBLE | this_ANY_OTHER_16= RULE_ANY_OTHER )* )
            // InternalSTL.g:132:3: () otherlv_1= 'solid' ( (lv_name_2_0= ruleEString ) )? (this_ID_3= RULE_ID | this_WS_4= RULE_WS | this_STRING_5= RULE_STRING | this_DOUBLE_6= RULE_DOUBLE | this_ANY_OTHER_7= RULE_ANY_OTHER )* ( (lv_triangles_8_0= ruleTriangle ) )* (this_WS_9= RULE_WS )* otherlv_10= 'endsolid' ( ruleEString )? (this_ID_12= RULE_ID | this_WS_13= RULE_WS | this_STRING_14= RULE_STRING | this_DOUBLE_15= RULE_DOUBLE | this_ANY_OTHER_16= RULE_ANY_OTHER )*
            {
            // InternalSTL.g:132:3: ()
            // InternalSTL.g:133:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getShape_ImplAccess().getShapeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,12,FOLLOW_4); 

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
                    						"org.eclipse.january.geometry.model.STL.EString");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSTL.g:162:3: (this_ID_3= RULE_ID | this_WS_4= RULE_WS | this_STRING_5= RULE_STRING | this_DOUBLE_6= RULE_DOUBLE | this_ANY_OTHER_7= RULE_ANY_OTHER )*
            loop3:
            do {
                int alt3=6;
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
                case RULE_DOUBLE:
                    {
                    alt3=4;
                    }
                    break;
                case RULE_ANY_OTHER:
                    {
                    alt3=5;
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
            	    // InternalSTL.g:178:4: this_DOUBLE_6= RULE_DOUBLE
            	    {
            	    this_DOUBLE_6=(Token)match(input,RULE_DOUBLE,FOLLOW_4); 

            	    				newLeafNode(this_DOUBLE_6, grammarAccess.getShape_ImplAccess().getDOUBLETerminalRuleCall_3_3());
            	    			

            	    }
            	    break;
            	case 5 :
            	    // InternalSTL.g:183:4: this_ANY_OTHER_7= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_7=(Token)match(input,RULE_ANY_OTHER,FOLLOW_4); 

            	    				newLeafNode(this_ANY_OTHER_7, grammarAccess.getShape_ImplAccess().getANY_OTHERTerminalRuleCall_3_4());
            	    			

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalSTL.g:188:3: ( (lv_triangles_8_0= ruleTriangle ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalSTL.g:189:4: (lv_triangles_8_0= ruleTriangle )
            	    {
            	    // InternalSTL.g:189:4: (lv_triangles_8_0= ruleTriangle )
            	    // InternalSTL.g:190:5: lv_triangles_8_0= ruleTriangle
            	    {

            	    					newCompositeNode(grammarAccess.getShape_ImplAccess().getTrianglesTriangleParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_triangles_8_0=ruleTriangle();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getShape_ImplRule());
            	    					}
            	    					add(
            	    						current,
            	    						"triangles",
            	    						lv_triangles_8_0,
            	    						"org.eclipse.january.geometry.model.STL.Triangle");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalSTL.g:207:3: (this_WS_9= RULE_WS )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_WS) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalSTL.g:208:4: this_WS_9= RULE_WS
            	    {
            	    this_WS_9=(Token)match(input,RULE_WS,FOLLOW_6); 

            	    				newLeafNode(this_WS_9, grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_5());
            	    			

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_10=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_10, grammarAccess.getShape_ImplAccess().getEndsolidKeyword_6());
            		
            // InternalSTL.g:217:3: ( ruleEString )?
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
                    // InternalSTL.g:218:4: ruleEString
                    {

                    				newCompositeNode(grammarAccess.getShape_ImplAccess().getEStringParserRuleCall_7());
                    			
                    pushFollow(FOLLOW_7);
                    ruleEString();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalSTL.g:226:3: (this_ID_12= RULE_ID | this_WS_13= RULE_WS | this_STRING_14= RULE_STRING | this_DOUBLE_15= RULE_DOUBLE | this_ANY_OTHER_16= RULE_ANY_OTHER )*
            loop7:
            do {
                int alt7=6;
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
                case RULE_DOUBLE:
                    {
                    alt7=4;
                    }
                    break;
                case RULE_ANY_OTHER:
                    {
                    alt7=5;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // InternalSTL.g:227:4: this_ID_12= RULE_ID
            	    {
            	    this_ID_12=(Token)match(input,RULE_ID,FOLLOW_7); 

            	    				newLeafNode(this_ID_12, grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_8_0());
            	    			

            	    }
            	    break;
            	case 2 :
            	    // InternalSTL.g:232:4: this_WS_13= RULE_WS
            	    {
            	    this_WS_13=(Token)match(input,RULE_WS,FOLLOW_7); 

            	    				newLeafNode(this_WS_13, grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_8_1());
            	    			

            	    }
            	    break;
            	case 3 :
            	    // InternalSTL.g:237:4: this_STRING_14= RULE_STRING
            	    {
            	    this_STRING_14=(Token)match(input,RULE_STRING,FOLLOW_7); 

            	    				newLeafNode(this_STRING_14, grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_8_2());
            	    			

            	    }
            	    break;
            	case 4 :
            	    // InternalSTL.g:242:4: this_DOUBLE_15= RULE_DOUBLE
            	    {
            	    this_DOUBLE_15=(Token)match(input,RULE_DOUBLE,FOLLOW_7); 

            	    				newLeafNode(this_DOUBLE_15, grammarAccess.getShape_ImplAccess().getDOUBLETerminalRuleCall_8_3());
            	    			

            	    }
            	    break;
            	case 5 :
            	    // InternalSTL.g:247:4: this_ANY_OTHER_16= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_16=(Token)match(input,RULE_ANY_OTHER,FOLLOW_7); 

            	    				newLeafNode(this_ANY_OTHER_16, grammarAccess.getShape_ImplAccess().getANY_OTHERTerminalRuleCall_8_4());
            	    			

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
    // InternalSTL.g:256:1: entryRuleTriangle returns [EObject current=null] : iv_ruleTriangle= ruleTriangle EOF ;
    public final EObject entryRuleTriangle() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriangle = null;


        try {
            // InternalSTL.g:256:49: (iv_ruleTriangle= ruleTriangle EOF )
            // InternalSTL.g:257:2: iv_ruleTriangle= ruleTriangle EOF
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
    // InternalSTL.g:263:1: ruleTriangle returns [EObject current=null] : ( () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )* otherlv_8= 'endloop' otherlv_9= 'endfacet' ) ;
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
            // InternalSTL.g:269:2: ( ( () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )* otherlv_8= 'endloop' otherlv_9= 'endfacet' ) )
            // InternalSTL.g:270:2: ( () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )* otherlv_8= 'endloop' otherlv_9= 'endfacet' )
            {
            // InternalSTL.g:270:2: ( () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )* otherlv_8= 'endloop' otherlv_9= 'endfacet' )
            // InternalSTL.g:271:3: () otherlv_1= 'facet' (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) ) otherlv_4= 'outer' otherlv_5= 'loop' (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )* otherlv_8= 'endloop' otherlv_9= 'endfacet'
            {
            // InternalSTL.g:271:3: ()
            // InternalSTL.g:272:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTriangleAccess().getTriangleAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getTriangleAccess().getFacetKeyword_1());
            		
            // InternalSTL.g:282:3: (otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) ) )
            // InternalSTL.g:283:4: otherlv_2= 'normal' ( (lv_normal_3_0= ruleVertex ) )
            {
            otherlv_2=(Token)match(input,15,FOLLOW_9); 

            				newLeafNode(otherlv_2, grammarAccess.getTriangleAccess().getNormalKeyword_2_0());
            			
            // InternalSTL.g:287:4: ( (lv_normal_3_0= ruleVertex ) )
            // InternalSTL.g:288:5: (lv_normal_3_0= ruleVertex )
            {
            // InternalSTL.g:288:5: (lv_normal_3_0= ruleVertex )
            // InternalSTL.g:289:6: lv_normal_3_0= ruleVertex
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
            							"org.eclipse.january.geometry.model.STL.Vertex");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getTriangleAccess().getOuterKeyword_3());
            		
            otherlv_5=(Token)match(input,17,FOLLOW_12); 

            			newLeafNode(otherlv_5, grammarAccess.getTriangleAccess().getLoopKeyword_4());
            		
            // InternalSTL.g:315:3: (otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalSTL.g:316:4: otherlv_6= 'vertex' ( (lv_vertices_7_0= ruleVertex ) )
            	    {
            	    otherlv_6=(Token)match(input,18,FOLLOW_9); 

            	    				newLeafNode(otherlv_6, grammarAccess.getTriangleAccess().getVertexKeyword_5_0());
            	    			
            	    // InternalSTL.g:320:4: ( (lv_vertices_7_0= ruleVertex ) )
            	    // InternalSTL.g:321:5: (lv_vertices_7_0= ruleVertex )
            	    {
            	    // InternalSTL.g:321:5: (lv_vertices_7_0= ruleVertex )
            	    // InternalSTL.g:322:6: lv_vertices_7_0= ruleVertex
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
            	    							"org.eclipse.january.geometry.model.STL.Vertex");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_8=(Token)match(input,19,FOLLOW_13); 

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
    // InternalSTL.g:352:1: entryRuleVertex returns [EObject current=null] : iv_ruleVertex= ruleVertex EOF ;
    public final EObject entryRuleVertex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVertex = null;


        try {
            // InternalSTL.g:352:47: (iv_ruleVertex= ruleVertex EOF )
            // InternalSTL.g:353:2: iv_ruleVertex= ruleVertex EOF
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
    // InternalSTL.g:359:1: ruleVertex returns [EObject current=null] : ( () ( (lv_x_1_0= RULE_DOUBLE ) ) ( (lv_y_2_0= RULE_DOUBLE ) ) ( (lv_z_3_0= RULE_DOUBLE ) ) ) ;
    public final EObject ruleVertex() throws RecognitionException {
        EObject current = null;

        Token lv_x_1_0=null;
        Token lv_y_2_0=null;
        Token lv_z_3_0=null;


        	enterRule();

        try {
            // InternalSTL.g:365:2: ( ( () ( (lv_x_1_0= RULE_DOUBLE ) ) ( (lv_y_2_0= RULE_DOUBLE ) ) ( (lv_z_3_0= RULE_DOUBLE ) ) ) )
            // InternalSTL.g:366:2: ( () ( (lv_x_1_0= RULE_DOUBLE ) ) ( (lv_y_2_0= RULE_DOUBLE ) ) ( (lv_z_3_0= RULE_DOUBLE ) ) )
            {
            // InternalSTL.g:366:2: ( () ( (lv_x_1_0= RULE_DOUBLE ) ) ( (lv_y_2_0= RULE_DOUBLE ) ) ( (lv_z_3_0= RULE_DOUBLE ) ) )
            // InternalSTL.g:367:3: () ( (lv_x_1_0= RULE_DOUBLE ) ) ( (lv_y_2_0= RULE_DOUBLE ) ) ( (lv_z_3_0= RULE_DOUBLE ) )
            {
            // InternalSTL.g:367:3: ()
            // InternalSTL.g:368:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVertexAccess().getVertexAction_0(),
            					current);
            			

            }

            // InternalSTL.g:374:3: ( (lv_x_1_0= RULE_DOUBLE ) )
            // InternalSTL.g:375:4: (lv_x_1_0= RULE_DOUBLE )
            {
            // InternalSTL.g:375:4: (lv_x_1_0= RULE_DOUBLE )
            // InternalSTL.g:376:5: lv_x_1_0= RULE_DOUBLE
            {
            lv_x_1_0=(Token)match(input,RULE_DOUBLE,FOLLOW_9); 

            					newLeafNode(lv_x_1_0, grammarAccess.getVertexAccess().getXDOUBLETerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVertexRule());
            					}
            					setWithLastConsumed(
            						current,
            						"x",
            						lv_x_1_0,
            						"org.eclipse.january.geometry.model.STL.DOUBLE");
            				

            }


            }

            // InternalSTL.g:392:3: ( (lv_y_2_0= RULE_DOUBLE ) )
            // InternalSTL.g:393:4: (lv_y_2_0= RULE_DOUBLE )
            {
            // InternalSTL.g:393:4: (lv_y_2_0= RULE_DOUBLE )
            // InternalSTL.g:394:5: lv_y_2_0= RULE_DOUBLE
            {
            lv_y_2_0=(Token)match(input,RULE_DOUBLE,FOLLOW_9); 

            					newLeafNode(lv_y_2_0, grammarAccess.getVertexAccess().getYDOUBLETerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVertexRule());
            					}
            					setWithLastConsumed(
            						current,
            						"y",
            						lv_y_2_0,
            						"org.eclipse.january.geometry.model.STL.DOUBLE");
            				

            }


            }

            // InternalSTL.g:410:3: ( (lv_z_3_0= RULE_DOUBLE ) )
            // InternalSTL.g:411:4: (lv_z_3_0= RULE_DOUBLE )
            {
            // InternalSTL.g:411:4: (lv_z_3_0= RULE_DOUBLE )
            // InternalSTL.g:412:5: lv_z_3_0= RULE_DOUBLE
            {
            lv_z_3_0=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

            					newLeafNode(lv_z_3_0, grammarAccess.getVertexAccess().getZDOUBLETerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVertexRule());
            					}
            					setWithLastConsumed(
            						current,
            						"z",
            						lv_z_3_0,
            						"org.eclipse.january.geometry.model.STL.DOUBLE");
            				

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


    // $ANTLR start "entryRuleEString"
    // InternalSTL.g:432:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalSTL.g:432:47: (iv_ruleEString= ruleEString EOF )
            // InternalSTL.g:433:2: iv_ruleEString= ruleEString EOF
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
    // InternalSTL.g:439:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalSTL.g:445:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalSTL.g:446:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalSTL.g:446:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalSTL.g:447:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSTL.g:455:3: this_ID_1= RULE_ID
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000000061F0L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000006020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000000001F2L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});

}