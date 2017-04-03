package org.eclipse.january.geometry.dsl.vtk.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.january.geometry.dsl.vtk.services.VTKGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalVTKParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ENDLINE", "RULE_INT", "RULE_DOUBLE", "RULE_STRING", "RULE_ID", "RULE_SL_COMMENT", "RULE_WS", "RULE_ML_COMMENT", "RULE_ANY_OTHER", "'POLYGONS'", "'TRIANGLE_STRIPS'", "'POINTS'", "'-'", "'.'", "'/'", "'\\\\'", "':'", "'_'"
    };
    public static final int RULE_ENDLINE=4;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int RULE_DOUBLE=6;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=8;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalVTKParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalVTKParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalVTKParser.tokenNames; }
    public String getGrammarFileName() { return "InternalVTK.g"; }



     	private VTKGrammarAccess grammarAccess;

        public InternalVTKParser(TokenStream input, VTKGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Geometry";
       	}

       	@Override
       	protected VTKGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleGeometry"
    // InternalVTK.g:64:1: entryRuleGeometry returns [EObject current=null] : iv_ruleGeometry= ruleGeometry EOF ;
    public final EObject entryRuleGeometry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeometry = null;


        try {
            // InternalVTK.g:64:49: (iv_ruleGeometry= ruleGeometry EOF )
            // InternalVTK.g:65:2: iv_ruleGeometry= ruleGeometry EOF
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
    // InternalVTK.g:71:1: ruleGeometry returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) (this_ENDLINE_2= RULE_ENDLINE | ( (lv_vertexSources_3_0= ruleVertexSource ) ) | ( (otherlv_4= 'POLYGONS' this_INT_5= RULE_INT this_INT_6= RULE_INT (this_ENDLINE_7= RULE_ENDLINE )? ) ( (lv_nodes_8_0= rulePolyShape ) )* ) | ( (otherlv_9= 'TRIANGLE_STRIPS' this_INT_10= RULE_INT this_INT_11= RULE_INT (this_ENDLINE_12= RULE_ENDLINE )? ) ( (lv_nodes_13_0= ruleTriangleStripPolyShape ) )* ) )* ) ;
    public final EObject ruleGeometry() throws RecognitionException {
        EObject current = null;

        Token this_ENDLINE_2=null;
        Token otherlv_4=null;
        Token this_INT_5=null;
        Token this_INT_6=null;
        Token this_ENDLINE_7=null;
        Token otherlv_9=null;
        Token this_INT_10=null;
        Token this_INT_11=null;
        Token this_ENDLINE_12=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_vertexSources_3_0 = null;

        EObject lv_nodes_8_0 = null;

        EObject lv_nodes_13_0 = null;



        	enterRule();

        try {
            // InternalVTK.g:77:2: ( ( () ( (lv_name_1_0= ruleEString ) ) (this_ENDLINE_2= RULE_ENDLINE | ( (lv_vertexSources_3_0= ruleVertexSource ) ) | ( (otherlv_4= 'POLYGONS' this_INT_5= RULE_INT this_INT_6= RULE_INT (this_ENDLINE_7= RULE_ENDLINE )? ) ( (lv_nodes_8_0= rulePolyShape ) )* ) | ( (otherlv_9= 'TRIANGLE_STRIPS' this_INT_10= RULE_INT this_INT_11= RULE_INT (this_ENDLINE_12= RULE_ENDLINE )? ) ( (lv_nodes_13_0= ruleTriangleStripPolyShape ) )* ) )* ) )
            // InternalVTK.g:78:2: ( () ( (lv_name_1_0= ruleEString ) ) (this_ENDLINE_2= RULE_ENDLINE | ( (lv_vertexSources_3_0= ruleVertexSource ) ) | ( (otherlv_4= 'POLYGONS' this_INT_5= RULE_INT this_INT_6= RULE_INT (this_ENDLINE_7= RULE_ENDLINE )? ) ( (lv_nodes_8_0= rulePolyShape ) )* ) | ( (otherlv_9= 'TRIANGLE_STRIPS' this_INT_10= RULE_INT this_INT_11= RULE_INT (this_ENDLINE_12= RULE_ENDLINE )? ) ( (lv_nodes_13_0= ruleTriangleStripPolyShape ) )* ) )* )
            {
            // InternalVTK.g:78:2: ( () ( (lv_name_1_0= ruleEString ) ) (this_ENDLINE_2= RULE_ENDLINE | ( (lv_vertexSources_3_0= ruleVertexSource ) ) | ( (otherlv_4= 'POLYGONS' this_INT_5= RULE_INT this_INT_6= RULE_INT (this_ENDLINE_7= RULE_ENDLINE )? ) ( (lv_nodes_8_0= rulePolyShape ) )* ) | ( (otherlv_9= 'TRIANGLE_STRIPS' this_INT_10= RULE_INT this_INT_11= RULE_INT (this_ENDLINE_12= RULE_ENDLINE )? ) ( (lv_nodes_13_0= ruleTriangleStripPolyShape ) )* ) )* )
            // InternalVTK.g:79:3: () ( (lv_name_1_0= ruleEString ) ) (this_ENDLINE_2= RULE_ENDLINE | ( (lv_vertexSources_3_0= ruleVertexSource ) ) | ( (otherlv_4= 'POLYGONS' this_INT_5= RULE_INT this_INT_6= RULE_INT (this_ENDLINE_7= RULE_ENDLINE )? ) ( (lv_nodes_8_0= rulePolyShape ) )* ) | ( (otherlv_9= 'TRIANGLE_STRIPS' this_INT_10= RULE_INT this_INT_11= RULE_INT (this_ENDLINE_12= RULE_ENDLINE )? ) ( (lv_nodes_13_0= ruleTriangleStripPolyShape ) )* ) )*
            {
            // InternalVTK.g:79:3: ()
            // InternalVTK.g:80:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGeometryAccess().getGeometryAction_0(),
            					current);
            			

            }

            // InternalVTK.g:86:3: ( (lv_name_1_0= ruleEString ) )
            // InternalVTK.g:87:4: (lv_name_1_0= ruleEString )
            {
            // InternalVTK.g:87:4: (lv_name_1_0= ruleEString )
            // InternalVTK.g:88:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getGeometryAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGeometryRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.january.geometry.dsl.vtk.VTK.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalVTK.g:105:3: (this_ENDLINE_2= RULE_ENDLINE | ( (lv_vertexSources_3_0= ruleVertexSource ) ) | ( (otherlv_4= 'POLYGONS' this_INT_5= RULE_INT this_INT_6= RULE_INT (this_ENDLINE_7= RULE_ENDLINE )? ) ( (lv_nodes_8_0= rulePolyShape ) )* ) | ( (otherlv_9= 'TRIANGLE_STRIPS' this_INT_10= RULE_INT this_INT_11= RULE_INT (this_ENDLINE_12= RULE_ENDLINE )? ) ( (lv_nodes_13_0= ruleTriangleStripPolyShape ) )* ) )*
            loop5:
            do {
                int alt5=5;
                switch ( input.LA(1) ) {
                case RULE_ENDLINE:
                    {
                    alt5=1;
                    }
                    break;
                case RULE_INT:
                case RULE_DOUBLE:
                case 15:
                case 16:
                    {
                    alt5=2;
                    }
                    break;
                case 13:
                    {
                    alt5=3;
                    }
                    break;
                case 14:
                    {
                    alt5=4;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // InternalVTK.g:106:4: this_ENDLINE_2= RULE_ENDLINE
            	    {
            	    this_ENDLINE_2=(Token)match(input,RULE_ENDLINE,FOLLOW_3); 

            	    				newLeafNode(this_ENDLINE_2, grammarAccess.getGeometryAccess().getENDLINETerminalRuleCall_2_0());
            	    			

            	    }
            	    break;
            	case 2 :
            	    // InternalVTK.g:111:4: ( (lv_vertexSources_3_0= ruleVertexSource ) )
            	    {
            	    // InternalVTK.g:111:4: ( (lv_vertexSources_3_0= ruleVertexSource ) )
            	    // InternalVTK.g:112:5: (lv_vertexSources_3_0= ruleVertexSource )
            	    {
            	    // InternalVTK.g:112:5: (lv_vertexSources_3_0= ruleVertexSource )
            	    // InternalVTK.g:113:6: lv_vertexSources_3_0= ruleVertexSource
            	    {

            	    						newCompositeNode(grammarAccess.getGeometryAccess().getVertexSourcesVertexSourceParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_3);
            	    lv_vertexSources_3_0=ruleVertexSource();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getGeometryRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vertexSources",
            	    							lv_vertexSources_3_0,
            	    							"org.eclipse.january.geometry.dsl.vtk.VTK.VertexSource");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalVTK.g:131:4: ( (otherlv_4= 'POLYGONS' this_INT_5= RULE_INT this_INT_6= RULE_INT (this_ENDLINE_7= RULE_ENDLINE )? ) ( (lv_nodes_8_0= rulePolyShape ) )* )
            	    {
            	    // InternalVTK.g:131:4: ( (otherlv_4= 'POLYGONS' this_INT_5= RULE_INT this_INT_6= RULE_INT (this_ENDLINE_7= RULE_ENDLINE )? ) ( (lv_nodes_8_0= rulePolyShape ) )* )
            	    // InternalVTK.g:132:5: (otherlv_4= 'POLYGONS' this_INT_5= RULE_INT this_INT_6= RULE_INT (this_ENDLINE_7= RULE_ENDLINE )? ) ( (lv_nodes_8_0= rulePolyShape ) )*
            	    {
            	    // InternalVTK.g:132:5: (otherlv_4= 'POLYGONS' this_INT_5= RULE_INT this_INT_6= RULE_INT (this_ENDLINE_7= RULE_ENDLINE )? )
            	    // InternalVTK.g:133:6: otherlv_4= 'POLYGONS' this_INT_5= RULE_INT this_INT_6= RULE_INT (this_ENDLINE_7= RULE_ENDLINE )?
            	    {
            	    otherlv_4=(Token)match(input,13,FOLLOW_4); 

            	    						newLeafNode(otherlv_4, grammarAccess.getGeometryAccess().getPOLYGONSKeyword_2_2_0_0());
            	    					
            	    this_INT_5=(Token)match(input,RULE_INT,FOLLOW_4); 

            	    						newLeafNode(this_INT_5, grammarAccess.getGeometryAccess().getINTTerminalRuleCall_2_2_0_1());
            	    					
            	    this_INT_6=(Token)match(input,RULE_INT,FOLLOW_3); 

            	    						newLeafNode(this_INT_6, grammarAccess.getGeometryAccess().getINTTerminalRuleCall_2_2_0_2());
            	    					
            	    // InternalVTK.g:145:6: (this_ENDLINE_7= RULE_ENDLINE )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==RULE_ENDLINE) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // InternalVTK.g:146:7: this_ENDLINE_7= RULE_ENDLINE
            	            {
            	            this_ENDLINE_7=(Token)match(input,RULE_ENDLINE,FOLLOW_3); 

            	            							newLeafNode(this_ENDLINE_7, grammarAccess.getGeometryAccess().getENDLINETerminalRuleCall_2_2_0_3());
            	            						

            	            }
            	            break;

            	    }


            	    }

            	    // InternalVTK.g:152:5: ( (lv_nodes_8_0= rulePolyShape ) )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        alt2 = dfa2.predict(input);
            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalVTK.g:153:6: (lv_nodes_8_0= rulePolyShape )
            	    	    {
            	    	    // InternalVTK.g:153:6: (lv_nodes_8_0= rulePolyShape )
            	    	    // InternalVTK.g:154:7: lv_nodes_8_0= rulePolyShape
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getGeometryAccess().getNodesPolyShapeParserRuleCall_2_2_1_0());
            	    	    						
            	    	    pushFollow(FOLLOW_3);
            	    	    lv_nodes_8_0=rulePolyShape();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getGeometryRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"nodes",
            	    	    								lv_nodes_8_0,
            	    	    								"org.eclipse.january.geometry.dsl.vtk.VTK.PolyShape");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop2;
            	        }
            	    } while (true);


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalVTK.g:173:4: ( (otherlv_9= 'TRIANGLE_STRIPS' this_INT_10= RULE_INT this_INT_11= RULE_INT (this_ENDLINE_12= RULE_ENDLINE )? ) ( (lv_nodes_13_0= ruleTriangleStripPolyShape ) )* )
            	    {
            	    // InternalVTK.g:173:4: ( (otherlv_9= 'TRIANGLE_STRIPS' this_INT_10= RULE_INT this_INT_11= RULE_INT (this_ENDLINE_12= RULE_ENDLINE )? ) ( (lv_nodes_13_0= ruleTriangleStripPolyShape ) )* )
            	    // InternalVTK.g:174:5: (otherlv_9= 'TRIANGLE_STRIPS' this_INT_10= RULE_INT this_INT_11= RULE_INT (this_ENDLINE_12= RULE_ENDLINE )? ) ( (lv_nodes_13_0= ruleTriangleStripPolyShape ) )*
            	    {
            	    // InternalVTK.g:174:5: (otherlv_9= 'TRIANGLE_STRIPS' this_INT_10= RULE_INT this_INT_11= RULE_INT (this_ENDLINE_12= RULE_ENDLINE )? )
            	    // InternalVTK.g:175:6: otherlv_9= 'TRIANGLE_STRIPS' this_INT_10= RULE_INT this_INT_11= RULE_INT (this_ENDLINE_12= RULE_ENDLINE )?
            	    {
            	    otherlv_9=(Token)match(input,14,FOLLOW_4); 

            	    						newLeafNode(otherlv_9, grammarAccess.getGeometryAccess().getTRIANGLE_STRIPSKeyword_2_3_0_0());
            	    					
            	    this_INT_10=(Token)match(input,RULE_INT,FOLLOW_4); 

            	    						newLeafNode(this_INT_10, grammarAccess.getGeometryAccess().getINTTerminalRuleCall_2_3_0_1());
            	    					
            	    this_INT_11=(Token)match(input,RULE_INT,FOLLOW_3); 

            	    						newLeafNode(this_INT_11, grammarAccess.getGeometryAccess().getINTTerminalRuleCall_2_3_0_2());
            	    					
            	    // InternalVTK.g:187:6: (this_ENDLINE_12= RULE_ENDLINE )?
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==RULE_ENDLINE) ) {
            	        alt3=1;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // InternalVTK.g:188:7: this_ENDLINE_12= RULE_ENDLINE
            	            {
            	            this_ENDLINE_12=(Token)match(input,RULE_ENDLINE,FOLLOW_3); 

            	            							newLeafNode(this_ENDLINE_12, grammarAccess.getGeometryAccess().getENDLINETerminalRuleCall_2_3_0_3());
            	            						

            	            }
            	            break;

            	    }


            	    }

            	    // InternalVTK.g:194:5: ( (lv_nodes_13_0= ruleTriangleStripPolyShape ) )*
            	    loop4:
            	    do {
            	        int alt4=2;
            	        alt4 = dfa4.predict(input);
            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalVTK.g:195:6: (lv_nodes_13_0= ruleTriangleStripPolyShape )
            	    	    {
            	    	    // InternalVTK.g:195:6: (lv_nodes_13_0= ruleTriangleStripPolyShape )
            	    	    // InternalVTK.g:196:7: lv_nodes_13_0= ruleTriangleStripPolyShape
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getGeometryAccess().getNodesTriangleStripPolyShapeParserRuleCall_2_3_1_0());
            	    	    						
            	    	    pushFollow(FOLLOW_3);
            	    	    lv_nodes_13_0=ruleTriangleStripPolyShape();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getGeometryRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"nodes",
            	    	    								lv_nodes_13_0,
            	    	    								"org.eclipse.january.geometry.dsl.vtk.VTK.TriangleStripPolyShape");
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
            	    break;

            	default :
            	    break loop5;
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


    // $ANTLR start "entryRuleVertexSource"
    // InternalVTK.g:219:1: entryRuleVertexSource returns [EObject current=null] : iv_ruleVertexSource= ruleVertexSource EOF ;
    public final EObject entryRuleVertexSource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVertexSource = null;


        try {
            // InternalVTK.g:219:53: (iv_ruleVertexSource= ruleVertexSource EOF )
            // InternalVTK.g:220:2: iv_ruleVertexSource= ruleVertexSource EOF
            {
             newCompositeNode(grammarAccess.getVertexSourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVertexSource=ruleVertexSource();

            state._fsp--;

             current =iv_ruleVertexSource; 
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
    // $ANTLR end "entryRuleVertexSource"


    // $ANTLR start "ruleVertexSource"
    // InternalVTK.g:226:1: ruleVertexSource returns [EObject current=null] : ( () (otherlv_1= 'POINTS' ( ruleEString )? (this_ENDLINE_3= RULE_ENDLINE )? )? ( (lv_vertices_4_0= ruleVertex ) )+ ) ;
    public final EObject ruleVertexSource() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_ENDLINE_3=null;
        EObject lv_vertices_4_0 = null;



        	enterRule();

        try {
            // InternalVTK.g:232:2: ( ( () (otherlv_1= 'POINTS' ( ruleEString )? (this_ENDLINE_3= RULE_ENDLINE )? )? ( (lv_vertices_4_0= ruleVertex ) )+ ) )
            // InternalVTK.g:233:2: ( () (otherlv_1= 'POINTS' ( ruleEString )? (this_ENDLINE_3= RULE_ENDLINE )? )? ( (lv_vertices_4_0= ruleVertex ) )+ )
            {
            // InternalVTK.g:233:2: ( () (otherlv_1= 'POINTS' ( ruleEString )? (this_ENDLINE_3= RULE_ENDLINE )? )? ( (lv_vertices_4_0= ruleVertex ) )+ )
            // InternalVTK.g:234:3: () (otherlv_1= 'POINTS' ( ruleEString )? (this_ENDLINE_3= RULE_ENDLINE )? )? ( (lv_vertices_4_0= ruleVertex ) )+
            {
            // InternalVTK.g:234:3: ()
            // InternalVTK.g:235:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVertexSourceAccess().getVertexSourceAction_0(),
            					current);
            			

            }

            // InternalVTK.g:241:3: (otherlv_1= 'POINTS' ( ruleEString )? (this_ENDLINE_3= RULE_ENDLINE )? )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalVTK.g:242:4: otherlv_1= 'POINTS' ( ruleEString )? (this_ENDLINE_3= RULE_ENDLINE )?
                    {
                    otherlv_1=(Token)match(input,15,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getVertexSourceAccess().getPOINTSKeyword_1_0());
                    			
                    // InternalVTK.g:246:4: ( ruleEString )?
                    int alt6=2;
                    alt6 = dfa6.predict(input);
                    switch (alt6) {
                        case 1 :
                            // InternalVTK.g:247:5: ruleEString
                            {

                            					newCompositeNode(grammarAccess.getVertexSourceAccess().getEStringParserRuleCall_1_1());
                            				
                            pushFollow(FOLLOW_6);
                            ruleEString();

                            state._fsp--;


                            					afterParserOrEnumRuleCall();
                            				

                            }
                            break;

                    }

                    // InternalVTK.g:255:4: (this_ENDLINE_3= RULE_ENDLINE )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==RULE_ENDLINE) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalVTK.g:256:5: this_ENDLINE_3= RULE_ENDLINE
                            {
                            this_ENDLINE_3=(Token)match(input,RULE_ENDLINE,FOLLOW_7); 

                            					newLeafNode(this_ENDLINE_3, grammarAccess.getVertexSourceAccess().getENDLINETerminalRuleCall_1_2());
                            				

                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalVTK.g:262:3: ( (lv_vertices_4_0= ruleVertex ) )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                switch ( input.LA(1) ) {
                case RULE_DOUBLE:
                    {
                    alt9=1;
                    }
                    break;
                case 16:
                    {
                    alt9=1;
                    }
                    break;
                case RULE_INT:
                    {
                    alt9=1;
                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // InternalVTK.g:263:4: (lv_vertices_4_0= ruleVertex )
            	    {
            	    // InternalVTK.g:263:4: (lv_vertices_4_0= ruleVertex )
            	    // InternalVTK.g:264:5: lv_vertices_4_0= ruleVertex
            	    {

            	    					newCompositeNode(grammarAccess.getVertexSourceAccess().getVerticesVertexParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_vertices_4_0=ruleVertex();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getVertexSourceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"vertices",
            	    						lv_vertices_4_0,
            	    						"org.eclipse.january.geometry.dsl.vtk.VTK.Vertex");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
    // $ANTLR end "ruleVertexSource"


    // $ANTLR start "entryRuleEDouble"
    // InternalVTK.g:285:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalVTK.g:285:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalVTK.g:286:2: iv_ruleEDouble= ruleEDouble EOF
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
    // InternalVTK.g:292:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_0=null;
        AntlrDatatypeRuleToken this_EInt_1 = null;



        	enterRule();

        try {
            // InternalVTK.g:298:2: ( (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt ) )
            // InternalVTK.g:299:2: (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt )
            {
            // InternalVTK.g:299:2: (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_DOUBLE) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_INT||LA10_0==16) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalVTK.g:300:3: this_DOUBLE_0= RULE_DOUBLE
                    {
                    this_DOUBLE_0=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

                    			current.merge(this_DOUBLE_0);
                    		

                    			newLeafNode(this_DOUBLE_0, grammarAccess.getEDoubleAccess().getDOUBLETerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalVTK.g:308:3: this_EInt_1= ruleEInt
                    {

                    			newCompositeNode(grammarAccess.getEDoubleAccess().getEIntParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EInt_1=ruleEInt();

                    state._fsp--;


                    			current.merge(this_EInt_1);
                    		

                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleEDouble"


    // $ANTLR start "entryRuleEInt"
    // InternalVTK.g:322:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalVTK.g:322:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalVTK.g:323:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
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
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalVTK.g:329:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalVTK.g:335:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalVTK.g:336:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalVTK.g:336:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalVTK.g:337:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalVTK.g:337:3: (kw= '-' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalVTK.g:338:4: kw= '-'
                    {
                    kw=(Token)match(input,16,FOLLOW_4); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1());
            		

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
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleEString"
    // InternalVTK.g:355:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalVTK.g:355:47: (iv_ruleEString= ruleEString EOF )
            // InternalVTK.g:356:2: iv_ruleEString= ruleEString EOF
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
    // InternalVTK.g:362:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_INT_2= RULE_INT | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' | kw= '_' | kw= '-' )+ ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;
        Token this_INT_2=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalVTK.g:368:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_INT_2= RULE_INT | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' | kw= '_' | kw= '-' )+ )
            // InternalVTK.g:369:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_INT_2= RULE_INT | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' | kw= '_' | kw= '-' )+
            {
            // InternalVTK.g:369:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_INT_2= RULE_INT | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' | kw= '_' | kw= '-' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=10;
                alt12 = dfa12.predict(input);
                switch (alt12) {
            	case 1 :
            	    // InternalVTK.g:370:3: this_STRING_0= RULE_STRING
            	    {
            	    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

            	    			current.merge(this_STRING_0);
            	    		

            	    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalVTK.g:378:3: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    			current.merge(this_ID_1);
            	    		

            	    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalVTK.g:386:3: this_INT_2= RULE_INT
            	    {
            	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_9); 

            	    			current.merge(this_INT_2);
            	    		

            	    			newLeafNode(this_INT_2, grammarAccess.getEStringAccess().getINTTerminalRuleCall_2());
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalVTK.g:394:3: kw= '.'
            	    {
            	    kw=(Token)match(input,17,FOLLOW_9); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getFullStopKeyword_3());
            	    		

            	    }
            	    break;
            	case 5 :
            	    // InternalVTK.g:400:3: kw= '/'
            	    {
            	    kw=(Token)match(input,18,FOLLOW_9); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getSolidusKeyword_4());
            	    		

            	    }
            	    break;
            	case 6 :
            	    // InternalVTK.g:406:3: kw= '\\\\'
            	    {
            	    kw=(Token)match(input,19,FOLLOW_9); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getReverseSolidusKeyword_5());
            	    		

            	    }
            	    break;
            	case 7 :
            	    // InternalVTK.g:412:3: kw= ':'
            	    {
            	    kw=(Token)match(input,20,FOLLOW_9); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getColonKeyword_6());
            	    		

            	    }
            	    break;
            	case 8 :
            	    // InternalVTK.g:418:3: kw= '_'
            	    {
            	    kw=(Token)match(input,21,FOLLOW_9); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().get_Keyword_7());
            	    		

            	    }
            	    break;
            	case 9 :
            	    // InternalVTK.g:424:3: kw= '-'
            	    {
            	    kw=(Token)match(input,16,FOLLOW_9); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getHyphenMinusKeyword_8());
            	    		

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


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


    // $ANTLR start "entryRuleFace"
    // InternalVTK.g:433:1: entryRuleFace returns [EObject current=null] : iv_ruleFace= ruleFace EOF ;
    public final EObject entryRuleFace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFace = null;


        try {
            // InternalVTK.g:433:45: (iv_ruleFace= ruleFace EOF )
            // InternalVTK.g:434:2: iv_ruleFace= ruleFace EOF
            {
             newCompositeNode(grammarAccess.getFaceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFace=ruleFace();

            state._fsp--;

             current =iv_ruleFace; 
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
    // $ANTLR end "entryRuleFace"


    // $ANTLR start "ruleFace"
    // InternalVTK.g:440:1: ruleFace returns [EObject current=null] : ( () ruleEInt ( (lv_vertexIndices_2_0= ruleEInt ) )+ (this_ENDLINE_3= RULE_ENDLINE )? ) ;
    public final EObject ruleFace() throws RecognitionException {
        EObject current = null;

        Token this_ENDLINE_3=null;
        AntlrDatatypeRuleToken lv_vertexIndices_2_0 = null;



        	enterRule();

        try {
            // InternalVTK.g:446:2: ( ( () ruleEInt ( (lv_vertexIndices_2_0= ruleEInt ) )+ (this_ENDLINE_3= RULE_ENDLINE )? ) )
            // InternalVTK.g:447:2: ( () ruleEInt ( (lv_vertexIndices_2_0= ruleEInt ) )+ (this_ENDLINE_3= RULE_ENDLINE )? )
            {
            // InternalVTK.g:447:2: ( () ruleEInt ( (lv_vertexIndices_2_0= ruleEInt ) )+ (this_ENDLINE_3= RULE_ENDLINE )? )
            // InternalVTK.g:448:3: () ruleEInt ( (lv_vertexIndices_2_0= ruleEInt ) )+ (this_ENDLINE_3= RULE_ENDLINE )?
            {
            // InternalVTK.g:448:3: ()
            // InternalVTK.g:449:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFaceAccess().getFaceAction_0(),
            					current);
            			

            }


            			newCompositeNode(grammarAccess.getFaceAccess().getEIntParserRuleCall_1());
            		
            pushFollow(FOLLOW_7);
            ruleEInt();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            // InternalVTK.g:462:3: ( (lv_vertexIndices_2_0= ruleEInt ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==16) ) {
                    int LA13_2 = input.LA(2);

                    if ( (LA13_2==RULE_INT) ) {
                        alt13=1;
                    }


                }
                else if ( (LA13_0==RULE_INT) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalVTK.g:463:4: (lv_vertexIndices_2_0= ruleEInt )
            	    {
            	    // InternalVTK.g:463:4: (lv_vertexIndices_2_0= ruleEInt )
            	    // InternalVTK.g:464:5: lv_vertexIndices_2_0= ruleEInt
            	    {

            	    					newCompositeNode(grammarAccess.getFaceAccess().getVertexIndicesEIntParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_vertexIndices_2_0=ruleEInt();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFaceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"vertexIndices",
            	    						lv_vertexIndices_2_0,
            	    						"org.eclipse.january.geometry.dsl.vtk.VTK.EInt");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            // InternalVTK.g:481:3: (this_ENDLINE_3= RULE_ENDLINE )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ENDLINE) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalVTK.g:482:4: this_ENDLINE_3= RULE_ENDLINE
                    {
                    this_ENDLINE_3=(Token)match(input,RULE_ENDLINE,FOLLOW_2); 

                    				newLeafNode(this_ENDLINE_3, grammarAccess.getFaceAccess().getENDLINETerminalRuleCall_3());
                    			

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
    // $ANTLR end "ruleFace"


    // $ANTLR start "entryRulePolyShape"
    // InternalVTK.g:491:1: entryRulePolyShape returns [EObject current=null] : iv_rulePolyShape= rulePolyShape EOF ;
    public final EObject entryRulePolyShape() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePolyShape = null;


        try {
            // InternalVTK.g:491:50: (iv_rulePolyShape= rulePolyShape EOF )
            // InternalVTK.g:492:2: iv_rulePolyShape= rulePolyShape EOF
            {
             newCompositeNode(grammarAccess.getPolyShapeRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePolyShape=rulePolyShape();

            state._fsp--;

             current =iv_rulePolyShape; 
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
    // $ANTLR end "entryRulePolyShape"


    // $ANTLR start "rulePolyShape"
    // InternalVTK.g:498:1: rulePolyShape returns [EObject current=null] : ( () ( (lv_faces_1_0= ruleFace ) )+ ) ;
    public final EObject rulePolyShape() throws RecognitionException {
        EObject current = null;

        EObject lv_faces_1_0 = null;



        	enterRule();

        try {
            // InternalVTK.g:504:2: ( ( () ( (lv_faces_1_0= ruleFace ) )+ ) )
            // InternalVTK.g:505:2: ( () ( (lv_faces_1_0= ruleFace ) )+ )
            {
            // InternalVTK.g:505:2: ( () ( (lv_faces_1_0= ruleFace ) )+ )
            // InternalVTK.g:506:3: () ( (lv_faces_1_0= ruleFace ) )+
            {
            // InternalVTK.g:506:3: ()
            // InternalVTK.g:507:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPolyShapeAccess().getPolyShapeAction_0(),
            					current);
            			

            }

            // InternalVTK.g:513:3: ( (lv_faces_1_0= ruleFace ) )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==16) ) {
                    alt15=1;
                }
                else if ( (LA15_0==RULE_INT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalVTK.g:514:4: (lv_faces_1_0= ruleFace )
            	    {
            	    // InternalVTK.g:514:4: (lv_faces_1_0= ruleFace )
            	    // InternalVTK.g:515:5: lv_faces_1_0= ruleFace
            	    {

            	    					newCompositeNode(grammarAccess.getPolyShapeAccess().getFacesFaceParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_faces_1_0=ruleFace();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPolyShapeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"faces",
            	    						lv_faces_1_0,
            	    						"org.eclipse.january.geometry.dsl.vtk.VTK.Face");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
    // $ANTLR end "rulePolyShape"


    // $ANTLR start "entryRuleTriangleStripPolyShape"
    // InternalVTK.g:536:1: entryRuleTriangleStripPolyShape returns [EObject current=null] : iv_ruleTriangleStripPolyShape= ruleTriangleStripPolyShape EOF ;
    public final EObject entryRuleTriangleStripPolyShape() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriangleStripPolyShape = null;


        try {
            // InternalVTK.g:536:63: (iv_ruleTriangleStripPolyShape= ruleTriangleStripPolyShape EOF )
            // InternalVTK.g:537:2: iv_ruleTriangleStripPolyShape= ruleTriangleStripPolyShape EOF
            {
             newCompositeNode(grammarAccess.getTriangleStripPolyShapeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTriangleStripPolyShape=ruleTriangleStripPolyShape();

            state._fsp--;

             current =iv_ruleTriangleStripPolyShape; 
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
    // $ANTLR end "entryRuleTriangleStripPolyShape"


    // $ANTLR start "ruleTriangleStripPolyShape"
    // InternalVTK.g:543:1: ruleTriangleStripPolyShape returns [EObject current=null] : ( () ( (lv_faces_1_0= ruleFace ) )+ ) ;
    public final EObject ruleTriangleStripPolyShape() throws RecognitionException {
        EObject current = null;

        EObject lv_faces_1_0 = null;



        	enterRule();

        try {
            // InternalVTK.g:549:2: ( ( () ( (lv_faces_1_0= ruleFace ) )+ ) )
            // InternalVTK.g:550:2: ( () ( (lv_faces_1_0= ruleFace ) )+ )
            {
            // InternalVTK.g:550:2: ( () ( (lv_faces_1_0= ruleFace ) )+ )
            // InternalVTK.g:551:3: () ( (lv_faces_1_0= ruleFace ) )+
            {
            // InternalVTK.g:551:3: ()
            // InternalVTK.g:552:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTriangleStripPolyShapeAccess().getTriangleStripPolyShapeAction_0(),
            					current);
            			

            }

            // InternalVTK.g:558:3: ( (lv_faces_1_0= ruleFace ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==16) ) {
                    alt16=1;
                }
                else if ( (LA16_0==RULE_INT) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalVTK.g:559:4: (lv_faces_1_0= ruleFace )
            	    {
            	    // InternalVTK.g:559:4: (lv_faces_1_0= ruleFace )
            	    // InternalVTK.g:560:5: lv_faces_1_0= ruleFace
            	    {

            	    					newCompositeNode(grammarAccess.getTriangleStripPolyShapeAccess().getFacesFaceParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_faces_1_0=ruleFace();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTriangleStripPolyShapeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"faces",
            	    						lv_faces_1_0,
            	    						"org.eclipse.january.geometry.dsl.vtk.VTK.Face");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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
    // $ANTLR end "ruleTriangleStripPolyShape"


    // $ANTLR start "entryRuleVertex"
    // InternalVTK.g:581:1: entryRuleVertex returns [EObject current=null] : iv_ruleVertex= ruleVertex EOF ;
    public final EObject entryRuleVertex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVertex = null;


        try {
            // InternalVTK.g:581:47: (iv_ruleVertex= ruleVertex EOF )
            // InternalVTK.g:582:2: iv_ruleVertex= ruleVertex EOF
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
    // InternalVTK.g:588:1: ruleVertex returns [EObject current=null] : ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) ( ruleEInt )? (this_ENDLINE_5= RULE_ENDLINE )? ) ;
    public final EObject ruleVertex() throws RecognitionException {
        EObject current = null;

        Token this_ENDLINE_5=null;
        AntlrDatatypeRuleToken lv_x_1_0 = null;

        AntlrDatatypeRuleToken lv_y_2_0 = null;

        AntlrDatatypeRuleToken lv_z_3_0 = null;



        	enterRule();

        try {
            // InternalVTK.g:594:2: ( ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) ( ruleEInt )? (this_ENDLINE_5= RULE_ENDLINE )? ) )
            // InternalVTK.g:595:2: ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) ( ruleEInt )? (this_ENDLINE_5= RULE_ENDLINE )? )
            {
            // InternalVTK.g:595:2: ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) ( ruleEInt )? (this_ENDLINE_5= RULE_ENDLINE )? )
            // InternalVTK.g:596:3: () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) ( ruleEInt )? (this_ENDLINE_5= RULE_ENDLINE )?
            {
            // InternalVTK.g:596:3: ()
            // InternalVTK.g:597:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVertexAccess().getVertexAction_0(),
            					current);
            			

            }

            // InternalVTK.g:603:3: ( (lv_x_1_0= ruleEDouble ) )
            // InternalVTK.g:604:4: (lv_x_1_0= ruleEDouble )
            {
            // InternalVTK.g:604:4: (lv_x_1_0= ruleEDouble )
            // InternalVTK.g:605:5: lv_x_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getVertexAccess().getXEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_7);
            lv_x_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVertexRule());
            					}
            					set(
            						current,
            						"x",
            						lv_x_1_0,
            						"org.eclipse.january.geometry.dsl.vtk.VTK.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalVTK.g:622:3: ( (lv_y_2_0= ruleEDouble ) )
            // InternalVTK.g:623:4: (lv_y_2_0= ruleEDouble )
            {
            // InternalVTK.g:623:4: (lv_y_2_0= ruleEDouble )
            // InternalVTK.g:624:5: lv_y_2_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getVertexAccess().getYEDoubleParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
            lv_y_2_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVertexRule());
            					}
            					set(
            						current,
            						"y",
            						lv_y_2_0,
            						"org.eclipse.january.geometry.dsl.vtk.VTK.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalVTK.g:641:3: ( (lv_z_3_0= ruleEDouble ) )
            // InternalVTK.g:642:4: (lv_z_3_0= ruleEDouble )
            {
            // InternalVTK.g:642:4: (lv_z_3_0= ruleEDouble )
            // InternalVTK.g:643:5: lv_z_3_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getVertexAccess().getZEDoubleParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_10);
            lv_z_3_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVertexRule());
            					}
            					set(
            						current,
            						"z",
            						lv_z_3_0,
            						"org.eclipse.january.geometry.dsl.vtk.VTK.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalVTK.g:660:3: ( ruleEInt )?
            int alt17=2;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // InternalVTK.g:661:4: ruleEInt
                    {

                    				newCompositeNode(grammarAccess.getVertexAccess().getEIntParserRuleCall_4());
                    			
                    pushFollow(FOLLOW_11);
                    ruleEInt();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalVTK.g:669:3: (this_ENDLINE_5= RULE_ENDLINE )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ENDLINE) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalVTK.g:670:4: this_ENDLINE_5= RULE_ENDLINE
                    {
                    this_ENDLINE_5=(Token)match(input,RULE_ENDLINE,FOLLOW_2); 

                    				newLeafNode(this_ENDLINE_5, grammarAccess.getVertexAccess().getENDLINETerminalRuleCall_5());
                    			

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
    // $ANTLR end "ruleVertex"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA17 dfa17 = new DFA17(this);
    static final String dfa_1s = "\34\uffff";
    static final String dfa_2s = "\1\1\4\uffff\1\10\1\1\4\uffff\1\1\1\23\1\uffff\1\23\1\26\1\uffff\1\26\2\uffff\1\1\2\uffff\1\1\1\uffff\1\1\2\uffff";
    static final String dfa_3s = "\1\4\1\uffff\3\5\2\4\1\5\1\uffff\2\5\2\4\1\5\2\4\1\5\1\4\1\5\1\uffff\1\4\1\5\1\uffff\1\4\1\5\1\4\1\5\1\uffff";
    static final String dfa_4s = "\1\20\1\uffff\1\5\1\20\1\5\2\20\1\5\1\uffff\1\20\1\5\2\20\1\5\2\20\1\5\1\20\1\5\1\uffff\1\20\1\5\1\uffff\1\20\1\5\1\20\1\5\1\uffff";
    static final String dfa_5s = "\1\uffff\1\2\6\uffff\1\1\12\uffff\1\1\2\uffff\1\1\4\uffff\1\1";
    static final String dfa_6s = "\34\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\1\3\1\1\6\uffff\3\1\1\2",
            "",
            "\1\3",
            "\1\5\1\1\11\uffff\1\4",
            "\1\5",
            "\2\10\1\6\6\uffff\3\10\1\7",
            "\1\1\1\13\1\11\6\uffff\3\1\1\12",
            "\1\10",
            "",
            "\1\16\1\14\11\uffff\1\15",
            "\1\13",
            "\1\1\1\21\1\17\6\uffff\3\1\1\20",
            "\2\23\1\6\6\uffff\3\23\1\22",
            "\1\16",
            "\2\23\1\6\6\uffff\3\23\1\22",
            "\2\26\1\24\6\uffff\3\26\1\25",
            "\1\21",
            "\2\26\1\24\6\uffff\3\26\1\25",
            "\1\23",
            "",
            "\1\1\1\31\1\27\6\uffff\3\1\1\30",
            "\1\26",
            "",
            "\1\1\1\33\1\17\6\uffff\3\1\1\32",
            "\1\31",
            "\1\1\1\33\1\17\6\uffff\3\1\1\32",
            "\1\33",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 152:5: ( (lv_nodes_8_0= rulePolyShape ) )*";
        }
    }
    static final String dfa_8s = "\35\uffff";
    static final String dfa_9s = "\1\1\4\uffff\1\6\1\uffff\1\1\4\uffff\1\1\1\24\1\uffff\1\24\1\27\1\uffff\1\27\2\uffff\1\1\2\uffff\1\1\1\uffff\1\1\2\uffff";
    static final String dfa_10s = "\1\4\1\uffff\3\5\1\4\1\uffff\1\4\1\5\1\uffff\2\5\2\4\1\5\2\4\1\5\1\4\1\5\1\uffff\1\4\1\5\1\uffff\1\4\1\5\1\4\1\5\1\uffff";
    static final String dfa_11s = "\1\20\1\uffff\1\5\1\20\1\5\1\20\1\uffff\1\20\1\5\1\uffff\1\20\1\5\2\20\1\5\2\20\1\5\1\20\1\5\1\uffff\1\20\1\5\1\uffff\1\20\1\5\1\20\1\5\1\uffff";
    static final String dfa_12s = "\1\uffff\1\2\4\uffff\1\1\2\uffff\1\1\12\uffff\1\1\2\uffff\1\1\4\uffff\1\1";
    static final String dfa_13s = "\35\uffff}>";
    static final String[] dfa_14s = {
            "\1\1\1\3\1\1\6\uffff\3\1\1\2",
            "",
            "\1\3",
            "\1\5\1\1\11\uffff\1\4",
            "\1\5",
            "\1\6\1\11\1\7\6\uffff\2\11\1\6\1\10",
            "",
            "\1\1\1\14\1\12\6\uffff\3\1\1\13",
            "\1\11",
            "",
            "\1\17\1\15\11\uffff\1\16",
            "\1\14",
            "\1\1\1\22\1\20\6\uffff\3\1\1\21",
            "\2\24\1\7\6\uffff\3\24\1\23",
            "\1\17",
            "\2\24\1\7\6\uffff\3\24\1\23",
            "\2\27\1\25\6\uffff\3\27\1\26",
            "\1\22",
            "\2\27\1\25\6\uffff\3\27\1\26",
            "\1\24",
            "",
            "\1\1\1\32\1\30\6\uffff\3\1\1\31",
            "\1\27",
            "",
            "\1\1\1\34\1\20\6\uffff\3\1\1\33",
            "\1\32",
            "\1\1\1\34\1\20\6\uffff\3\1\1\33",
            "\1\34",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "()* loopback of 194:5: ( (lv_nodes_13_0= ruleTriangleStripPolyShape ) )*";
        }
    }
    static final String dfa_15s = "\57\uffff";
    static final String dfa_16s = "\10\uffff\1\4\1\uffff\2\4\2\uffff\1\23\2\uffff\1\23\4\uffff\1\23\1\41\1\uffff\1\41\1\4\1\uffff\2\4\1\uffff\1\4\2\uffff\1\47\2\uffff\1\47\3\uffff\1\47\1\56\1\uffff\1\56\2\uffff";
    static final String dfa_17s = "\1\4\1\uffff\1\4\2\uffff\1\5\3\4\1\5\3\4\1\uffff\1\4\1\5\1\uffff\1\4\1\5\1\uffff\2\5\2\4\1\5\2\4\1\5\2\4\1\5\1\4\1\5\1\uffff\1\4\1\5\1\uffff\1\4\1\5\1\uffff\1\5\2\4\1\5\1\4\1\5\1\uffff";
    static final String dfa_18s = "\1\25\1\uffff\1\25\2\uffff\1\20\2\25\1\20\1\5\2\20\1\25\1\uffff\1\20\1\5\1\uffff\1\20\1\5\1\uffff\1\20\1\5\2\20\1\5\2\20\1\5\2\20\1\5\1\20\1\5\1\uffff\1\20\1\5\1\uffff\1\20\1\5\1\uffff\1\5\2\20\1\5\1\20\1\5\1\uffff";
    static final String dfa_19s = "\1\uffff\1\1\1\uffff\1\1\1\2\10\uffff\1\1\2\uffff\1\1\2\uffff\1\1\15\uffff\1\1\2\uffff\1\1\2\uffff\1\1\6\uffff\1\1";
    static final String dfa_20s = "\57\uffff}>";
    static final String[] dfa_21s = {
            "\1\4\1\2\1\4\2\1\7\uffff\1\3\5\1",
            "",
            "\1\3\1\7\1\5\1\1\1\3\7\uffff\1\6\5\3",
            "",
            "",
            "\1\12\1\10\11\uffff\1\11",
            "\1\3\1\7\1\3\1\1\1\3\7\uffff\6\3",
            "\2\15\1\13\1\1\1\15\7\uffff\1\14\5\15",
            "\1\4\1\20\1\16\6\uffff\3\4\1\17",
            "\1\12",
            "\1\4\1\20\1\16\6\uffff\3\4\1\17",
            "\1\4\1\23\1\21\6\uffff\3\4\1\22",
            "\1\23\1\15\1\23\1\1\1\23\7\uffff\6\23",
            "",
            "\1\23\1\26\1\24\6\uffff\3\23\1\25",
            "\1\20",
            "",
            "\1\23\1\31\1\27\6\uffff\3\23\1\30",
            "\1\23",
            "",
            "\1\34\1\32\11\uffff\1\33",
            "\1\26",
            "\1\23\1\37\1\35\6\uffff\3\23\1\36",
            "\2\41\1\35\6\uffff\3\41\1\40",
            "\1\31",
            "\2\41\1\35\6\uffff\3\41\1\40",
            "\1\4\1\44\1\42\6\uffff\3\4\1\43",
            "\1\34",
            "\1\4\1\44\1\42\6\uffff\3\4\1\43",
            "\1\4\1\47\1\45\6\uffff\3\4\1\46",
            "\1\37",
            "\1\4\1\47\1\45\6\uffff\3\4\1\46",
            "\1\41",
            "",
            "\1\47\1\51\1\24\6\uffff\3\47\1\50",
            "\1\44",
            "",
            "\1\47\1\54\1\52\6\uffff\3\47\1\53",
            "\1\47",
            "",
            "\1\51",
            "\1\47\1\37\1\35\6\uffff\3\47\1\36",
            "\2\56\1\35\6\uffff\3\56\1\55",
            "\1\54",
            "\2\56\1\35\6\uffff\3\56\1\55",
            "\1\56",
            ""
    };

    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_15;
            this.eof = dfa_16;
            this.min = dfa_17;
            this.max = dfa_18;
            this.accept = dfa_19;
            this.special = dfa_20;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "246:4: ( ruleEString )?";
        }
    }
    static final String dfa_22s = "\44\uffff";
    static final String dfa_23s = "\1\1\2\uffff\1\16\10\uffff\1\16\1\24\1\uffff\1\1\1\uffff\2\1\1\31\3\uffff\1\31\2\uffff\1\31\1\uffff\1\31\1\43\1\uffff\1\43\1\uffff\1\1\2\uffff";
    static final String dfa_24s = "\1\4\2\uffff\1\4\7\uffff\1\5\2\4\1\uffff\1\4\1\5\3\4\1\uffff\1\5\1\uffff\1\4\1\5\1\uffff\1\4\1\5\2\4\1\5\1\4\1\5\1\4\1\5\1\uffff";
    static final String dfa_25s = "\1\25\2\uffff\1\25\7\uffff\1\20\2\25\1\uffff\1\20\1\5\2\20\1\25\1\uffff\1\5\1\uffff\1\20\1\5\1\uffff\1\20\1\5\2\20\1\5\1\20\1\5\1\20\1\5\1\uffff";
    static final String dfa_26s = "\1\uffff\1\12\1\11\1\uffff\1\1\1\2\1\4\1\5\1\6\1\7\1\10\3\uffff\1\3\5\uffff\1\3\1\uffff\1\3\2\uffff\1\3\11\uffff\1\3";
    static final String dfa_27s = "\44\uffff}>";
    static final String[] dfa_28s = {
            "\1\1\1\3\1\1\1\4\1\5\4\uffff\3\1\1\2\1\6\1\7\1\10\1\11\1\12",
            "",
            "",
            "\1\16\1\15\1\13\2\16\4\uffff\3\16\1\14\5\16",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\21\1\17\11\uffff\1\20",
            "\1\16\1\15\3\16\4\uffff\11\16",
            "\1\16\1\24\1\22\2\24\4\uffff\3\24\1\23\5\24",
            "",
            "\1\1\1\26\1\27\6\uffff\3\1\1\25",
            "\1\21",
            "\1\1\1\26\1\27\6\uffff\3\1\1\25",
            "\1\1\1\31\1\32\6\uffff\3\1\1\30",
            "\1\16\1\24\3\31\4\uffff\11\31",
            "",
            "\1\26",
            "",
            "\1\31\1\34\1\13\6\uffff\3\31\1\33",
            "\1\31",
            "",
            "\1\31\1\37\1\35\6\uffff\3\31\1\36",
            "\1\34",
            "\1\31\1\41\1\22\6\uffff\3\31\1\40",
            "\2\43\1\22\6\uffff\3\43\1\42",
            "\1\37",
            "\2\43\1\22\6\uffff\3\43\1\42",
            "\1\41",
            "\1\1\1\31\1\32\6\uffff\3\1\1\30",
            "\1\43",
            ""
    };

    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
    static final char[] dfa_25 = DFA.unpackEncodedStringToUnsignedChars(dfa_25s);
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[][] dfa_28 = unpackEncodedStringArray(dfa_28s);

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_22;
            this.eof = dfa_23;
            this.min = dfa_24;
            this.max = dfa_25;
            this.accept = dfa_26;
            this.special = dfa_27;
            this.transition = dfa_28;
        }
        public String getDescription() {
            return "()+ loopback of 369:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_INT_2= RULE_INT | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' | kw= '_' | kw= '-' )+";
        }
    }
    static final String dfa_29s = "\33\uffff";
    static final String dfa_30s = "\1\3\1\uffff\1\4\5\uffff\1\3\1\uffff\1\3\1\15\3\uffff\1\15\1\3\1\uffff\1\3\1\25\2\uffff\1\32\1\uffff\1\32\2\uffff";
    static final String dfa_31s = "\1\4\1\5\1\4\2\uffff\3\5\1\4\1\5\2\4\1\5\1\uffff\1\5\2\4\1\5\2\4\1\5\1\uffff\1\4\1\5\1\4\1\5\1\uffff";
    static final String dfa_32s = "\1\20\1\5\1\20\2\uffff\1\20\1\5\2\20\1\5\2\20\1\5\1\uffff\1\5\2\20\1\5\2\20\1\5\1\uffff\1\20\1\5\1\20\1\5\1\uffff";
    static final String dfa_33s = "\3\uffff\1\2\1\1\10\uffff\1\1\7\uffff\1\1\4\uffff\1\1";
    static final String dfa_34s = "\33\uffff}>";
    static final String[] dfa_35s = {
            "\1\3\1\2\1\3\6\uffff\3\3\1\1",
            "\1\2",
            "\1\4\1\7\1\5\6\uffff\3\4\1\6",
            "",
            "",
            "\1\12\1\10\11\uffff\1\11",
            "\1\7",
            "\1\12\1\10\11\uffff\1\11",
            "\1\3\1\15\1\13\6\uffff\3\3\1\14",
            "\1\12",
            "\1\3\1\15\1\13\6\uffff\3\3\1\14",
            "\1\15\1\17\1\5\6\uffff\3\15\1\16",
            "\1\15",
            "",
            "\1\17",
            "\1\15\1\22\1\20\6\uffff\3\15\1\21",
            "\1\3\1\25\1\23\6\uffff\3\3\1\24",
            "\1\22",
            "\1\3\1\25\1\23\6\uffff\3\3\1\24",
            "\1\25\1\30\1\26\6\uffff\3\25\1\27",
            "\1\25",
            "",
            "\2\32\1\20\6\uffff\3\32\1\31",
            "\1\30",
            "\2\32\1\20\6\uffff\3\32\1\31",
            "\1\32",
            ""
    };

    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final char[] dfa_32 = DFA.unpackEncodedStringToUnsignedChars(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);
    static final short[][] dfa_35 = unpackEncodedStringArray(dfa_35s);

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = dfa_29;
            this.eof = dfa_30;
            this.min = dfa_31;
            this.max = dfa_32;
            this.accept = dfa_33;
            this.special = dfa_34;
            this.transition = dfa_35;
        }
        public String getDescription() {
            return "660:3: ( ruleEInt )?";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000001E072L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000003F81F0L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000018070L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000018060L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000018062L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000003F01A2L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000018072L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000012L});

}