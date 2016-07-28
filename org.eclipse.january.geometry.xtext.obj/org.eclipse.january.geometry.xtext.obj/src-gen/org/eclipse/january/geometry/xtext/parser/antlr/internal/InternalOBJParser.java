package org.eclipse.january.geometry.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.january.geometry.xtext.services.OBJGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOBJParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_DOUBLE", "RULE_SL_COMMENT", "RULE_WS", "RULE_ML_COMMENT", "RULE_ANY_OTHER", "'mtllib'", "'g'", "'v'", "'vt'", "'vn'", "'usemtl'", "'f'", "'s'", "'off'", "'/'", "'-'", "'.'", "'\\\\'", "':'", "'_'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
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
    public static final int RULE_ID=6;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int RULE_INT=4;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalOBJParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOBJParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOBJParser.tokenNames; }
    public String getGrammarFileName() { return "InternalOBJ.g"; }



     	private OBJGrammarAccess grammarAccess;

        public InternalOBJParser(TokenStream input, OBJGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Geometry";
       	}

       	@Override
       	protected OBJGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleGeometry"
    // InternalOBJ.g:64:1: entryRuleGeometry returns [EObject current=null] : iv_ruleGeometry= ruleGeometry EOF ;
    public final EObject entryRuleGeometry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeometry = null;


        try {
            // InternalOBJ.g:64:49: (iv_ruleGeometry= ruleGeometry EOF )
            // InternalOBJ.g:65:2: iv_ruleGeometry= ruleGeometry EOF
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
    // InternalOBJ.g:71:1: ruleGeometry returns [EObject current=null] : ( ( (lv_vertexSources_0_0= ruleVertexSource ) ) | ( (lv_nodes_1_0= rulePolyShape ) ) )* ;
    public final EObject ruleGeometry() throws RecognitionException {
        EObject current = null;

        EObject lv_vertexSources_0_0 = null;

        EObject lv_nodes_1_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:77:2: ( ( ( (lv_vertexSources_0_0= ruleVertexSource ) ) | ( (lv_nodes_1_0= rulePolyShape ) ) )* )
            // InternalOBJ.g:78:2: ( ( (lv_vertexSources_0_0= ruleVertexSource ) ) | ( (lv_nodes_1_0= rulePolyShape ) ) )*
            {
            // InternalOBJ.g:78:2: ( ( (lv_vertexSources_0_0= ruleVertexSource ) ) | ( (lv_nodes_1_0= rulePolyShape ) ) )*
            loop1:
            do {
                int alt1=3;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // InternalOBJ.g:79:3: ( (lv_vertexSources_0_0= ruleVertexSource ) )
            	    {
            	    // InternalOBJ.g:79:3: ( (lv_vertexSources_0_0= ruleVertexSource ) )
            	    // InternalOBJ.g:80:4: (lv_vertexSources_0_0= ruleVertexSource )
            	    {
            	    // InternalOBJ.g:80:4: (lv_vertexSources_0_0= ruleVertexSource )
            	    // InternalOBJ.g:81:5: lv_vertexSources_0_0= ruleVertexSource
            	    {

            	    					newCompositeNode(grammarAccess.getGeometryAccess().getVertexSourcesVertexSourceParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_vertexSources_0_0=ruleVertexSource();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGeometryRule());
            	    					}
            	    					add(
            	    						current,
            	    						"vertexSources",
            	    						lv_vertexSources_0_0,
            	    						"org.eclipse.january.geometry.xtext.OBJ.VertexSource");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOBJ.g:99:3: ( (lv_nodes_1_0= rulePolyShape ) )
            	    {
            	    // InternalOBJ.g:99:3: ( (lv_nodes_1_0= rulePolyShape ) )
            	    // InternalOBJ.g:100:4: (lv_nodes_1_0= rulePolyShape )
            	    {
            	    // InternalOBJ.g:100:4: (lv_nodes_1_0= rulePolyShape )
            	    // InternalOBJ.g:101:5: lv_nodes_1_0= rulePolyShape
            	    {

            	    					newCompositeNode(grammarAccess.getGeometryAccess().getNodesPolyShapeParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_nodes_1_0=rulePolyShape();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGeometryRule());
            	    					}
            	    					add(
            	    						current,
            	    						"nodes",
            	    						lv_nodes_1_0,
            	    						"org.eclipse.january.geometry.xtext.OBJ.PolyShape");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
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
    // $ANTLR end "ruleGeometry"


    // $ANTLR start "entryRuleVertexSource"
    // InternalOBJ.g:122:1: entryRuleVertexSource returns [EObject current=null] : iv_ruleVertexSource= ruleVertexSource EOF ;
    public final EObject entryRuleVertexSource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVertexSource = null;


        try {
            // InternalOBJ.g:122:53: (iv_ruleVertexSource= ruleVertexSource EOF )
            // InternalOBJ.g:123:2: iv_ruleVertexSource= ruleVertexSource EOF
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
    // InternalOBJ.g:129:1: ruleVertexSource returns [EObject current=null] : ( () (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )* (otherlv_3= 'g' ( ruleEString )? )? ( (otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) ) ) | (otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) ) ) | (otherlv_9= 'vn' ruleEDouble ruleEDouble ruleEDouble ) )+ ) ;
    public final EObject ruleVertexSource() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_materialFiles_2_0 = null;

        EObject lv_vertices_6_0 = null;

        EObject lv_textureCoordinates_8_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:135:2: ( ( () (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )* (otherlv_3= 'g' ( ruleEString )? )? ( (otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) ) ) | (otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) ) ) | (otherlv_9= 'vn' ruleEDouble ruleEDouble ruleEDouble ) )+ ) )
            // InternalOBJ.g:136:2: ( () (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )* (otherlv_3= 'g' ( ruleEString )? )? ( (otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) ) ) | (otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) ) ) | (otherlv_9= 'vn' ruleEDouble ruleEDouble ruleEDouble ) )+ )
            {
            // InternalOBJ.g:136:2: ( () (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )* (otherlv_3= 'g' ( ruleEString )? )? ( (otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) ) ) | (otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) ) ) | (otherlv_9= 'vn' ruleEDouble ruleEDouble ruleEDouble ) )+ )
            // InternalOBJ.g:137:3: () (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )* (otherlv_3= 'g' ( ruleEString )? )? ( (otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) ) ) | (otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) ) ) | (otherlv_9= 'vn' ruleEDouble ruleEDouble ruleEDouble ) )+
            {
            // InternalOBJ.g:137:3: ()
            // InternalOBJ.g:138:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVertexSourceAccess().getVertexSourceAction_0(),
            					current);
            			

            }

            // InternalOBJ.g:144:3: (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalOBJ.g:145:4: otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) )
            	    {
            	    otherlv_1=(Token)match(input,12,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getVertexSourceAccess().getMtllibKeyword_1_0());
            	    			
            	    // InternalOBJ.g:149:4: ( (lv_materialFiles_2_0= ruleEString ) )
            	    // InternalOBJ.g:150:5: (lv_materialFiles_2_0= ruleEString )
            	    {
            	    // InternalOBJ.g:150:5: (lv_materialFiles_2_0= ruleEString )
            	    // InternalOBJ.g:151:6: lv_materialFiles_2_0= ruleEString
            	    {

            	    						newCompositeNode(grammarAccess.getVertexSourceAccess().getMaterialFilesEStringParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_5);
            	    lv_materialFiles_2_0=ruleEString();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getVertexSourceRule());
            	    						}
            	    						add(
            	    							current,
            	    							"materialFiles",
            	    							lv_materialFiles_2_0,
            	    							"org.eclipse.january.geometry.xtext.OBJ.EString");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalOBJ.g:169:3: (otherlv_3= 'g' ( ruleEString )? )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalOBJ.g:170:4: otherlv_3= 'g' ( ruleEString )?
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getVertexSourceAccess().getGKeyword_2_0());
                    			
                    // InternalOBJ.g:174:4: ( ruleEString )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0>=RULE_INT && LA3_0<=RULE_ID)||(LA3_0>=21 && LA3_0<=26)) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalOBJ.g:175:5: ruleEString
                            {

                            					newCompositeNode(grammarAccess.getVertexSourceAccess().getEStringParserRuleCall_2_1());
                            				
                            pushFollow(FOLLOW_7);
                            ruleEString();

                            state._fsp--;


                            					afterParserOrEnumRuleCall();
                            				

                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalOBJ.g:184:3: ( (otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) ) ) | (otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) ) ) | (otherlv_9= 'vn' ruleEDouble ruleEDouble ruleEDouble ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=4;
                switch ( input.LA(1) ) {
                case 14:
                    {
                    alt5=1;
                    }
                    break;
                case 15:
                    {
                    alt5=2;
                    }
                    break;
                case 16:
                    {
                    alt5=3;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // InternalOBJ.g:185:4: (otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) ) )
            	    {
            	    // InternalOBJ.g:185:4: (otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) ) )
            	    // InternalOBJ.g:186:5: otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_8); 

            	    					newLeafNode(otherlv_5, grammarAccess.getVertexSourceAccess().getVKeyword_3_0_0());
            	    				
            	    // InternalOBJ.g:190:5: ( (lv_vertices_6_0= ruleVertex ) )
            	    // InternalOBJ.g:191:6: (lv_vertices_6_0= ruleVertex )
            	    {
            	    // InternalOBJ.g:191:6: (lv_vertices_6_0= ruleVertex )
            	    // InternalOBJ.g:192:7: lv_vertices_6_0= ruleVertex
            	    {

            	    							newCompositeNode(grammarAccess.getVertexSourceAccess().getVerticesVertexParserRuleCall_3_0_1_0());
            	    						
            	    pushFollow(FOLLOW_9);
            	    lv_vertices_6_0=ruleVertex();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getVertexSourceRule());
            	    							}
            	    							add(
            	    								current,
            	    								"vertices",
            	    								lv_vertices_6_0,
            	    								"org.eclipse.january.geometry.xtext.OBJ.Vertex");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOBJ.g:211:4: (otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) ) )
            	    {
            	    // InternalOBJ.g:211:4: (otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) ) )
            	    // InternalOBJ.g:212:5: otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) )
            	    {
            	    otherlv_7=(Token)match(input,15,FOLLOW_8); 

            	    					newLeafNode(otherlv_7, grammarAccess.getVertexSourceAccess().getVtKeyword_3_1_0());
            	    				
            	    // InternalOBJ.g:216:5: ( (lv_textureCoordinates_8_0= ruleTextureVertex ) )
            	    // InternalOBJ.g:217:6: (lv_textureCoordinates_8_0= ruleTextureVertex )
            	    {
            	    // InternalOBJ.g:217:6: (lv_textureCoordinates_8_0= ruleTextureVertex )
            	    // InternalOBJ.g:218:7: lv_textureCoordinates_8_0= ruleTextureVertex
            	    {

            	    							newCompositeNode(grammarAccess.getVertexSourceAccess().getTextureCoordinatesTextureVertexParserRuleCall_3_1_1_0());
            	    						
            	    pushFollow(FOLLOW_9);
            	    lv_textureCoordinates_8_0=ruleTextureVertex();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getVertexSourceRule());
            	    							}
            	    							add(
            	    								current,
            	    								"textureCoordinates",
            	    								lv_textureCoordinates_8_0,
            	    								"org.eclipse.january.geometry.xtext.OBJ.TextureVertex");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOBJ.g:237:4: (otherlv_9= 'vn' ruleEDouble ruleEDouble ruleEDouble )
            	    {
            	    // InternalOBJ.g:237:4: (otherlv_9= 'vn' ruleEDouble ruleEDouble ruleEDouble )
            	    // InternalOBJ.g:238:5: otherlv_9= 'vn' ruleEDouble ruleEDouble ruleEDouble
            	    {
            	    otherlv_9=(Token)match(input,16,FOLLOW_8); 

            	    					newLeafNode(otherlv_9, grammarAccess.getVertexSourceAccess().getVnKeyword_3_2_0());
            	    				

            	    					newCompositeNode(grammarAccess.getVertexSourceAccess().getEDoubleParserRuleCall_3_2_1());
            	    				
            	    pushFollow(FOLLOW_8);
            	    ruleEDouble();

            	    state._fsp--;


            	    					afterParserOrEnumRuleCall();
            	    				

            	    					newCompositeNode(grammarAccess.getVertexSourceAccess().getEDoubleParserRuleCall_3_2_2());
            	    				
            	    pushFollow(FOLLOW_8);
            	    ruleEDouble();

            	    state._fsp--;


            	    					afterParserOrEnumRuleCall();
            	    				

            	    					newCompositeNode(grammarAccess.getVertexSourceAccess().getEDoubleParserRuleCall_3_2_3());
            	    				
            	    pushFollow(FOLLOW_9);
            	    ruleEDouble();

            	    state._fsp--;


            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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


    // $ANTLR start "entryRulePolyShape"
    // InternalOBJ.g:269:1: entryRulePolyShape returns [EObject current=null] : iv_rulePolyShape= rulePolyShape EOF ;
    public final EObject entryRulePolyShape() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePolyShape = null;


        try {
            // InternalOBJ.g:269:50: (iv_rulePolyShape= rulePolyShape EOF )
            // InternalOBJ.g:270:2: iv_rulePolyShape= rulePolyShape EOF
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
    // InternalOBJ.g:276:1: rulePolyShape returns [EObject current=null] : ( () (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )* (otherlv_3= 'g' ( (lv_name_4_0= ruleEString ) )? )? (otherlv_5= 'usemtl' ( (lv_material_6_0= ruleMaterial ) ) )? ( (otherlv_7= 'f' ( (lv_faces_8_0= ruleFace ) ) ) | (otherlv_9= 's' ( ruleEInt | otherlv_11= 'off' ) ) )+ ) ;
    public final EObject rulePolyShape() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_materialFiles_2_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_material_6_0 = null;

        EObject lv_faces_8_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:282:2: ( ( () (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )* (otherlv_3= 'g' ( (lv_name_4_0= ruleEString ) )? )? (otherlv_5= 'usemtl' ( (lv_material_6_0= ruleMaterial ) ) )? ( (otherlv_7= 'f' ( (lv_faces_8_0= ruleFace ) ) ) | (otherlv_9= 's' ( ruleEInt | otherlv_11= 'off' ) ) )+ ) )
            // InternalOBJ.g:283:2: ( () (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )* (otherlv_3= 'g' ( (lv_name_4_0= ruleEString ) )? )? (otherlv_5= 'usemtl' ( (lv_material_6_0= ruleMaterial ) ) )? ( (otherlv_7= 'f' ( (lv_faces_8_0= ruleFace ) ) ) | (otherlv_9= 's' ( ruleEInt | otherlv_11= 'off' ) ) )+ )
            {
            // InternalOBJ.g:283:2: ( () (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )* (otherlv_3= 'g' ( (lv_name_4_0= ruleEString ) )? )? (otherlv_5= 'usemtl' ( (lv_material_6_0= ruleMaterial ) ) )? ( (otherlv_7= 'f' ( (lv_faces_8_0= ruleFace ) ) ) | (otherlv_9= 's' ( ruleEInt | otherlv_11= 'off' ) ) )+ )
            // InternalOBJ.g:284:3: () (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )* (otherlv_3= 'g' ( (lv_name_4_0= ruleEString ) )? )? (otherlv_5= 'usemtl' ( (lv_material_6_0= ruleMaterial ) ) )? ( (otherlv_7= 'f' ( (lv_faces_8_0= ruleFace ) ) ) | (otherlv_9= 's' ( ruleEInt | otherlv_11= 'off' ) ) )+
            {
            // InternalOBJ.g:284:3: ()
            // InternalOBJ.g:285:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPolyShapeAccess().getPolyShapeAction_0(),
            					current);
            			

            }

            // InternalOBJ.g:291:3: (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==12) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalOBJ.g:292:4: otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) )
            	    {
            	    otherlv_1=(Token)match(input,12,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getPolyShapeAccess().getMtllibKeyword_1_0());
            	    			
            	    // InternalOBJ.g:296:4: ( (lv_materialFiles_2_0= ruleEString ) )
            	    // InternalOBJ.g:297:5: (lv_materialFiles_2_0= ruleEString )
            	    {
            	    // InternalOBJ.g:297:5: (lv_materialFiles_2_0= ruleEString )
            	    // InternalOBJ.g:298:6: lv_materialFiles_2_0= ruleEString
            	    {

            	    						newCompositeNode(grammarAccess.getPolyShapeAccess().getMaterialFilesEStringParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_10);
            	    lv_materialFiles_2_0=ruleEString();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPolyShapeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"materialFiles",
            	    							lv_materialFiles_2_0,
            	    							"org.eclipse.january.geometry.xtext.OBJ.EString");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // InternalOBJ.g:316:3: (otherlv_3= 'g' ( (lv_name_4_0= ruleEString ) )? )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==13) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalOBJ.g:317:4: otherlv_3= 'g' ( (lv_name_4_0= ruleEString ) )?
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_11); 

                    				newLeafNode(otherlv_3, grammarAccess.getPolyShapeAccess().getGKeyword_2_0());
                    			
                    // InternalOBJ.g:321:4: ( (lv_name_4_0= ruleEString ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0>=RULE_INT && LA7_0<=RULE_ID)||(LA7_0>=21 && LA7_0<=26)) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalOBJ.g:322:5: (lv_name_4_0= ruleEString )
                            {
                            // InternalOBJ.g:322:5: (lv_name_4_0= ruleEString )
                            // InternalOBJ.g:323:6: lv_name_4_0= ruleEString
                            {

                            						newCompositeNode(grammarAccess.getPolyShapeAccess().getNameEStringParserRuleCall_2_1_0());
                            					
                            pushFollow(FOLLOW_12);
                            lv_name_4_0=ruleEString();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getPolyShapeRule());
                            						}
                            						set(
                            							current,
                            							"name",
                            							lv_name_4_0,
                            							"org.eclipse.january.geometry.xtext.OBJ.EString");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalOBJ.g:341:3: (otherlv_5= 'usemtl' ( (lv_material_6_0= ruleMaterial ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalOBJ.g:342:4: otherlv_5= 'usemtl' ( (lv_material_6_0= ruleMaterial ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_4); 

                    				newLeafNode(otherlv_5, grammarAccess.getPolyShapeAccess().getUsemtlKeyword_3_0());
                    			
                    // InternalOBJ.g:346:4: ( (lv_material_6_0= ruleMaterial ) )
                    // InternalOBJ.g:347:5: (lv_material_6_0= ruleMaterial )
                    {
                    // InternalOBJ.g:347:5: (lv_material_6_0= ruleMaterial )
                    // InternalOBJ.g:348:6: lv_material_6_0= ruleMaterial
                    {

                    						newCompositeNode(grammarAccess.getPolyShapeAccess().getMaterialMaterialParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_material_6_0=ruleMaterial();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPolyShapeRule());
                    						}
                    						set(
                    							current,
                    							"material",
                    							lv_material_6_0,
                    							"org.eclipse.january.geometry.xtext.OBJ.Material");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOBJ.g:366:3: ( (otherlv_7= 'f' ( (lv_faces_8_0= ruleFace ) ) ) | (otherlv_9= 's' ( ruleEInt | otherlv_11= 'off' ) ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==18) ) {
                    alt11=1;
                }
                else if ( (LA11_0==19) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalOBJ.g:367:4: (otherlv_7= 'f' ( (lv_faces_8_0= ruleFace ) ) )
            	    {
            	    // InternalOBJ.g:367:4: (otherlv_7= 'f' ( (lv_faces_8_0= ruleFace ) ) )
            	    // InternalOBJ.g:368:5: otherlv_7= 'f' ( (lv_faces_8_0= ruleFace ) )
            	    {
            	    otherlv_7=(Token)match(input,18,FOLLOW_14); 

            	    					newLeafNode(otherlv_7, grammarAccess.getPolyShapeAccess().getFKeyword_4_0_0());
            	    				
            	    // InternalOBJ.g:372:5: ( (lv_faces_8_0= ruleFace ) )
            	    // InternalOBJ.g:373:6: (lv_faces_8_0= ruleFace )
            	    {
            	    // InternalOBJ.g:373:6: (lv_faces_8_0= ruleFace )
            	    // InternalOBJ.g:374:7: lv_faces_8_0= ruleFace
            	    {

            	    							newCompositeNode(grammarAccess.getPolyShapeAccess().getFacesFaceParserRuleCall_4_0_1_0());
            	    						
            	    pushFollow(FOLLOW_15);
            	    lv_faces_8_0=ruleFace();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getPolyShapeRule());
            	    							}
            	    							add(
            	    								current,
            	    								"faces",
            	    								lv_faces_8_0,
            	    								"org.eclipse.january.geometry.xtext.OBJ.Face");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOBJ.g:393:4: (otherlv_9= 's' ( ruleEInt | otherlv_11= 'off' ) )
            	    {
            	    // InternalOBJ.g:393:4: (otherlv_9= 's' ( ruleEInt | otherlv_11= 'off' ) )
            	    // InternalOBJ.g:394:5: otherlv_9= 's' ( ruleEInt | otherlv_11= 'off' )
            	    {
            	    otherlv_9=(Token)match(input,19,FOLLOW_16); 

            	    					newLeafNode(otherlv_9, grammarAccess.getPolyShapeAccess().getSKeyword_4_1_0());
            	    				
            	    // InternalOBJ.g:398:5: ( ruleEInt | otherlv_11= 'off' )
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==RULE_INT||LA10_0==22) ) {
            	        alt10=1;
            	    }
            	    else if ( (LA10_0==20) ) {
            	        alt10=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // InternalOBJ.g:399:6: ruleEInt
            	            {

            	            						newCompositeNode(grammarAccess.getPolyShapeAccess().getEIntParserRuleCall_4_1_1_0());
            	            					
            	            pushFollow(FOLLOW_15);
            	            ruleEInt();

            	            state._fsp--;


            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // InternalOBJ.g:407:6: otherlv_11= 'off'
            	            {
            	            otherlv_11=(Token)match(input,20,FOLLOW_15); 

            	            						newLeafNode(otherlv_11, grammarAccess.getPolyShapeAccess().getOffKeyword_4_1_1_1());
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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


    // $ANTLR start "entryRuleFace"
    // InternalOBJ.g:418:1: entryRuleFace returns [EObject current=null] : iv_ruleFace= ruleFace EOF ;
    public final EObject entryRuleFace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFace = null;


        try {
            // InternalOBJ.g:418:45: (iv_ruleFace= ruleFace EOF )
            // InternalOBJ.g:419:2: iv_ruleFace= ruleFace EOF
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
    // InternalOBJ.g:425:1: ruleFace returns [EObject current=null] : ( () ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )* ) ;
    public final EObject ruleFace() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_vertexIndices_1_0 = null;

        AntlrDatatypeRuleToken lv_textureIndices_3_0 = null;

        AntlrDatatypeRuleToken lv_textureIndices_4_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:431:2: ( ( () ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )* ) )
            // InternalOBJ.g:432:2: ( () ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )* )
            {
            // InternalOBJ.g:432:2: ( () ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )* )
            // InternalOBJ.g:433:3: () ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )*
            {
            // InternalOBJ.g:433:3: ()
            // InternalOBJ.g:434:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFaceAccess().getFaceAction_0(),
            					current);
            			

            }

            // InternalOBJ.g:440:3: ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_INT||LA14_0==22) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalOBJ.g:441:4: ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )?
            	    {
            	    // InternalOBJ.g:441:4: ( (lv_vertexIndices_1_0= ruleEInt ) )
            	    // InternalOBJ.g:442:5: (lv_vertexIndices_1_0= ruleEInt )
            	    {
            	    // InternalOBJ.g:442:5: (lv_vertexIndices_1_0= ruleEInt )
            	    // InternalOBJ.g:443:6: lv_vertexIndices_1_0= ruleEInt
            	    {

            	    						newCompositeNode(grammarAccess.getFaceAccess().getVertexIndicesEIntParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_17);
            	    lv_vertexIndices_1_0=ruleEInt();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFaceRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vertexIndices",
            	    							lv_vertexIndices_1_0,
            	    							"org.eclipse.january.geometry.xtext.OBJ.EInt");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalOBJ.g:460:4: (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )?
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==21) ) {
            	        alt13=1;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // InternalOBJ.g:461:5: otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) )
            	            {
            	            otherlv_2=(Token)match(input,21,FOLLOW_18); 

            	            					newLeafNode(otherlv_2, grammarAccess.getFaceAccess().getSolidusKeyword_1_1_0());
            	            				
            	            // InternalOBJ.g:465:5: ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) )
            	            int alt12=3;
            	            switch ( input.LA(1) ) {
            	            case 22:
            	                {
            	                int LA12_1 = input.LA(2);

            	                if ( (LA12_1==RULE_INT) ) {
            	                    int LA12_2 = input.LA(3);

            	                    if ( (LA12_2==21) ) {
            	                        alt12=2;
            	                    }
            	                    else if ( (LA12_2==EOF||LA12_2==RULE_INT||(LA12_2>=12 && LA12_2<=19)||LA12_2==22) ) {
            	                        alt12=1;
            	                    }
            	                    else {
            	                        NoViableAltException nvae =
            	                            new NoViableAltException("", 12, 2, input);

            	                        throw nvae;
            	                    }
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("", 12, 1, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case RULE_INT:
            	                {
            	                int LA12_2 = input.LA(2);

            	                if ( (LA12_2==21) ) {
            	                    alt12=2;
            	                }
            	                else if ( (LA12_2==EOF||LA12_2==RULE_INT||(LA12_2>=12 && LA12_2<=19)||LA12_2==22) ) {
            	                    alt12=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("", 12, 2, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 21:
            	                {
            	                alt12=3;
            	                }
            	                break;
            	            default:
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 12, 0, input);

            	                throw nvae;
            	            }

            	            switch (alt12) {
            	                case 1 :
            	                    // InternalOBJ.g:466:6: ( (lv_textureIndices_3_0= ruleEInt ) )
            	                    {
            	                    // InternalOBJ.g:466:6: ( (lv_textureIndices_3_0= ruleEInt ) )
            	                    // InternalOBJ.g:467:7: (lv_textureIndices_3_0= ruleEInt )
            	                    {
            	                    // InternalOBJ.g:467:7: (lv_textureIndices_3_0= ruleEInt )
            	                    // InternalOBJ.g:468:8: lv_textureIndices_3_0= ruleEInt
            	                    {

            	                    								newCompositeNode(grammarAccess.getFaceAccess().getTextureIndicesEIntParserRuleCall_1_1_1_0_0());
            	                    							
            	                    pushFollow(FOLLOW_19);
            	                    lv_textureIndices_3_0=ruleEInt();

            	                    state._fsp--;


            	                    								if (current==null) {
            	                    									current = createModelElementForParent(grammarAccess.getFaceRule());
            	                    								}
            	                    								add(
            	                    									current,
            	                    									"textureIndices",
            	                    									lv_textureIndices_3_0,
            	                    									"org.eclipse.january.geometry.xtext.OBJ.EInt");
            	                    								afterParserOrEnumRuleCall();
            	                    							

            	                    }


            	                    }


            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalOBJ.g:486:6: ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt )
            	                    {
            	                    // InternalOBJ.g:486:6: ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt )
            	                    // InternalOBJ.g:487:7: ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt
            	                    {
            	                    // InternalOBJ.g:487:7: ( (lv_textureIndices_4_0= ruleEInt ) )
            	                    // InternalOBJ.g:488:8: (lv_textureIndices_4_0= ruleEInt )
            	                    {
            	                    // InternalOBJ.g:488:8: (lv_textureIndices_4_0= ruleEInt )
            	                    // InternalOBJ.g:489:9: lv_textureIndices_4_0= ruleEInt
            	                    {

            	                    									newCompositeNode(grammarAccess.getFaceAccess().getTextureIndicesEIntParserRuleCall_1_1_1_1_0_0());
            	                    								
            	                    pushFollow(FOLLOW_20);
            	                    lv_textureIndices_4_0=ruleEInt();

            	                    state._fsp--;


            	                    									if (current==null) {
            	                    										current = createModelElementForParent(grammarAccess.getFaceRule());
            	                    									}
            	                    									add(
            	                    										current,
            	                    										"textureIndices",
            	                    										lv_textureIndices_4_0,
            	                    										"org.eclipse.january.geometry.xtext.OBJ.EInt");
            	                    									afterParserOrEnumRuleCall();
            	                    								

            	                    }


            	                    }

            	                    otherlv_5=(Token)match(input,21,FOLLOW_8); 

            	                    							newLeafNode(otherlv_5, grammarAccess.getFaceAccess().getSolidusKeyword_1_1_1_1_1());
            	                    						

            	                    							newCompositeNode(grammarAccess.getFaceAccess().getEIntParserRuleCall_1_1_1_1_2());
            	                    						
            	                    pushFollow(FOLLOW_19);
            	                    ruleEInt();

            	                    state._fsp--;


            	                    							afterParserOrEnumRuleCall();
            	                    						

            	                    }


            	                    }
            	                    break;
            	                case 3 :
            	                    // InternalOBJ.g:519:6: (otherlv_7= '/' ruleEInt )
            	                    {
            	                    // InternalOBJ.g:519:6: (otherlv_7= '/' ruleEInt )
            	                    // InternalOBJ.g:520:7: otherlv_7= '/' ruleEInt
            	                    {
            	                    otherlv_7=(Token)match(input,21,FOLLOW_8); 

            	                    							newLeafNode(otherlv_7, grammarAccess.getFaceAccess().getSolidusKeyword_1_1_1_2_0());
            	                    						

            	                    							newCompositeNode(grammarAccess.getFaceAccess().getEIntParserRuleCall_1_1_1_2_1());
            	                    						
            	                    pushFollow(FOLLOW_19);
            	                    ruleEInt();

            	                    state._fsp--;


            	                    							afterParserOrEnumRuleCall();
            	                    						

            	                    }


            	                    }
            	                    break;

            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end "ruleFace"


    // $ANTLR start "entryRuleVertex"
    // InternalOBJ.g:539:1: entryRuleVertex returns [EObject current=null] : iv_ruleVertex= ruleVertex EOF ;
    public final EObject entryRuleVertex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVertex = null;


        try {
            // InternalOBJ.g:539:47: (iv_ruleVertex= ruleVertex EOF )
            // InternalOBJ.g:540:2: iv_ruleVertex= ruleVertex EOF
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
    // InternalOBJ.g:546:1: ruleVertex returns [EObject current=null] : ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) ) ;
    public final EObject ruleVertex() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_x_1_0 = null;

        AntlrDatatypeRuleToken lv_y_2_0 = null;

        AntlrDatatypeRuleToken lv_z_3_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:552:2: ( ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) ) )
            // InternalOBJ.g:553:2: ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) )
            {
            // InternalOBJ.g:553:2: ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) )
            // InternalOBJ.g:554:3: () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) )
            {
            // InternalOBJ.g:554:3: ()
            // InternalOBJ.g:555:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVertexAccess().getVertexAction_0(),
            					current);
            			

            }

            // InternalOBJ.g:561:3: ( (lv_x_1_0= ruleEDouble ) )
            // InternalOBJ.g:562:4: (lv_x_1_0= ruleEDouble )
            {
            // InternalOBJ.g:562:4: (lv_x_1_0= ruleEDouble )
            // InternalOBJ.g:563:5: lv_x_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getVertexAccess().getXEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_8);
            lv_x_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVertexRule());
            					}
            					set(
            						current,
            						"x",
            						lv_x_1_0,
            						"org.eclipse.january.geometry.xtext.OBJ.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOBJ.g:580:3: ( (lv_y_2_0= ruleEDouble ) )
            // InternalOBJ.g:581:4: (lv_y_2_0= ruleEDouble )
            {
            // InternalOBJ.g:581:4: (lv_y_2_0= ruleEDouble )
            // InternalOBJ.g:582:5: lv_y_2_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getVertexAccess().getYEDoubleParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_8);
            lv_y_2_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVertexRule());
            					}
            					set(
            						current,
            						"y",
            						lv_y_2_0,
            						"org.eclipse.january.geometry.xtext.OBJ.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOBJ.g:599:3: ( (lv_z_3_0= ruleEDouble ) )
            // InternalOBJ.g:600:4: (lv_z_3_0= ruleEDouble )
            {
            // InternalOBJ.g:600:4: (lv_z_3_0= ruleEDouble )
            // InternalOBJ.g:601:5: lv_z_3_0= ruleEDouble
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
            						"org.eclipse.january.geometry.xtext.OBJ.EDouble");
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


    // $ANTLR start "entryRuleTextureVertex"
    // InternalOBJ.g:622:1: entryRuleTextureVertex returns [EObject current=null] : iv_ruleTextureVertex= ruleTextureVertex EOF ;
    public final EObject entryRuleTextureVertex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextureVertex = null;


        try {
            // InternalOBJ.g:622:54: (iv_ruleTextureVertex= ruleTextureVertex EOF )
            // InternalOBJ.g:623:2: iv_ruleTextureVertex= ruleTextureVertex EOF
            {
             newCompositeNode(grammarAccess.getTextureVertexRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTextureVertex=ruleTextureVertex();

            state._fsp--;

             current =iv_ruleTextureVertex; 
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
    // $ANTLR end "entryRuleTextureVertex"


    // $ANTLR start "ruleTextureVertex"
    // InternalOBJ.g:629:1: ruleTextureVertex returns [EObject current=null] : ( ( (lv_x_0_0= ruleEDouble ) ) ( (lv_y_1_0= ruleEDouble ) ) ( (lv_z_2_0= ruleEDouble ) )? ) ;
    public final EObject ruleTextureVertex() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_x_0_0 = null;

        AntlrDatatypeRuleToken lv_y_1_0 = null;

        AntlrDatatypeRuleToken lv_z_2_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:635:2: ( ( ( (lv_x_0_0= ruleEDouble ) ) ( (lv_y_1_0= ruleEDouble ) ) ( (lv_z_2_0= ruleEDouble ) )? ) )
            // InternalOBJ.g:636:2: ( ( (lv_x_0_0= ruleEDouble ) ) ( (lv_y_1_0= ruleEDouble ) ) ( (lv_z_2_0= ruleEDouble ) )? )
            {
            // InternalOBJ.g:636:2: ( ( (lv_x_0_0= ruleEDouble ) ) ( (lv_y_1_0= ruleEDouble ) ) ( (lv_z_2_0= ruleEDouble ) )? )
            // InternalOBJ.g:637:3: ( (lv_x_0_0= ruleEDouble ) ) ( (lv_y_1_0= ruleEDouble ) ) ( (lv_z_2_0= ruleEDouble ) )?
            {
            // InternalOBJ.g:637:3: ( (lv_x_0_0= ruleEDouble ) )
            // InternalOBJ.g:638:4: (lv_x_0_0= ruleEDouble )
            {
            // InternalOBJ.g:638:4: (lv_x_0_0= ruleEDouble )
            // InternalOBJ.g:639:5: lv_x_0_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getTextureVertexAccess().getXEDoubleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_8);
            lv_x_0_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTextureVertexRule());
            					}
            					set(
            						current,
            						"x",
            						lv_x_0_0,
            						"org.eclipse.january.geometry.xtext.OBJ.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOBJ.g:656:3: ( (lv_y_1_0= ruleEDouble ) )
            // InternalOBJ.g:657:4: (lv_y_1_0= ruleEDouble )
            {
            // InternalOBJ.g:657:4: (lv_y_1_0= ruleEDouble )
            // InternalOBJ.g:658:5: lv_y_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getTextureVertexAccess().getYEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_19);
            lv_y_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTextureVertexRule());
            					}
            					set(
            						current,
            						"y",
            						lv_y_1_0,
            						"org.eclipse.january.geometry.xtext.OBJ.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOBJ.g:675:3: ( (lv_z_2_0= ruleEDouble ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_INT||LA15_0==RULE_DOUBLE||LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalOBJ.g:676:4: (lv_z_2_0= ruleEDouble )
                    {
                    // InternalOBJ.g:676:4: (lv_z_2_0= ruleEDouble )
                    // InternalOBJ.g:677:5: lv_z_2_0= ruleEDouble
                    {

                    					newCompositeNode(grammarAccess.getTextureVertexAccess().getZEDoubleParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_z_2_0=ruleEDouble();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTextureVertexRule());
                    					}
                    					set(
                    						current,
                    						"z",
                    						lv_z_2_0,
                    						"org.eclipse.january.geometry.xtext.OBJ.EDouble");
                    					afterParserOrEnumRuleCall();
                    				

                    }


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
    // $ANTLR end "ruleTextureVertex"


    // $ANTLR start "entryRuleMaterial"
    // InternalOBJ.g:698:1: entryRuleMaterial returns [EObject current=null] : iv_ruleMaterial= ruleMaterial EOF ;
    public final EObject entryRuleMaterial() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaterial = null;


        try {
            // InternalOBJ.g:698:49: (iv_ruleMaterial= ruleMaterial EOF )
            // InternalOBJ.g:699:2: iv_ruleMaterial= ruleMaterial EOF
            {
             newCompositeNode(grammarAccess.getMaterialRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMaterial=ruleMaterial();

            state._fsp--;

             current =iv_ruleMaterial; 
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
    // $ANTLR end "entryRuleMaterial"


    // $ANTLR start "ruleMaterial"
    // InternalOBJ.g:705:1: ruleMaterial returns [EObject current=null] : ( () ( (lv_phongMatName_1_0= ruleEString ) ) ) ;
    public final EObject ruleMaterial() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_phongMatName_1_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:711:2: ( ( () ( (lv_phongMatName_1_0= ruleEString ) ) ) )
            // InternalOBJ.g:712:2: ( () ( (lv_phongMatName_1_0= ruleEString ) ) )
            {
            // InternalOBJ.g:712:2: ( () ( (lv_phongMatName_1_0= ruleEString ) ) )
            // InternalOBJ.g:713:3: () ( (lv_phongMatName_1_0= ruleEString ) )
            {
            // InternalOBJ.g:713:3: ()
            // InternalOBJ.g:714:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMaterialAccess().getMaterialAction_0(),
            					current);
            			

            }

            // InternalOBJ.g:720:3: ( (lv_phongMatName_1_0= ruleEString ) )
            // InternalOBJ.g:721:4: (lv_phongMatName_1_0= ruleEString )
            {
            // InternalOBJ.g:721:4: (lv_phongMatName_1_0= ruleEString )
            // InternalOBJ.g:722:5: lv_phongMatName_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getMaterialAccess().getPhongMatNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_phongMatName_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMaterialRule());
            					}
            					set(
            						current,
            						"phongMatName",
            						lv_phongMatName_1_0,
            						"org.eclipse.january.geometry.xtext.OBJ.EString");
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
    // $ANTLR end "ruleMaterial"


    // $ANTLR start "entryRuleEInt"
    // InternalOBJ.g:743:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalOBJ.g:743:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalOBJ.g:744:2: iv_ruleEInt= ruleEInt EOF
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
    // InternalOBJ.g:750:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalOBJ.g:756:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalOBJ.g:757:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalOBJ.g:757:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalOBJ.g:758:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalOBJ.g:758:3: (kw= '-' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==22) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalOBJ.g:759:4: kw= '-'
                    {
                    kw=(Token)match(input,22,FOLLOW_21); 

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
    // InternalOBJ.g:776:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalOBJ.g:776:47: (iv_ruleEString= ruleEString EOF )
            // InternalOBJ.g:777:2: iv_ruleEString= ruleEString EOF
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
    // InternalOBJ.g:783:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_INT_2= RULE_INT | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' | kw= '_' | kw= '-' )+ ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;
        Token this_INT_2=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalOBJ.g:789:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_INT_2= RULE_INT | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' | kw= '_' | kw= '-' )+ )
            // InternalOBJ.g:790:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_INT_2= RULE_INT | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' | kw= '_' | kw= '-' )+
            {
            // InternalOBJ.g:790:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_INT_2= RULE_INT | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' | kw= '_' | kw= '-' )+
            int cnt17=0;
            loop17:
            do {
                int alt17=10;
                switch ( input.LA(1) ) {
                case RULE_STRING:
                    {
                    alt17=1;
                    }
                    break;
                case RULE_ID:
                    {
                    alt17=2;
                    }
                    break;
                case RULE_INT:
                    {
                    alt17=3;
                    }
                    break;
                case 23:
                    {
                    alt17=4;
                    }
                    break;
                case 21:
                    {
                    alt17=5;
                    }
                    break;
                case 24:
                    {
                    alt17=6;
                    }
                    break;
                case 25:
                    {
                    alt17=7;
                    }
                    break;
                case 26:
                    {
                    alt17=8;
                    }
                    break;
                case 22:
                    {
                    alt17=9;
                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // InternalOBJ.g:791:3: this_STRING_0= RULE_STRING
            	    {
            	    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_22); 

            	    			current.merge(this_STRING_0);
            	    		

            	    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalOBJ.g:799:3: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_22); 

            	    			current.merge(this_ID_1);
            	    		

            	    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalOBJ.g:807:3: this_INT_2= RULE_INT
            	    {
            	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_22); 

            	    			current.merge(this_INT_2);
            	    		

            	    			newLeafNode(this_INT_2, grammarAccess.getEStringAccess().getINTTerminalRuleCall_2());
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalOBJ.g:815:3: kw= '.'
            	    {
            	    kw=(Token)match(input,23,FOLLOW_22); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getFullStopKeyword_3());
            	    		

            	    }
            	    break;
            	case 5 :
            	    // InternalOBJ.g:821:3: kw= '/'
            	    {
            	    kw=(Token)match(input,21,FOLLOW_22); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getSolidusKeyword_4());
            	    		

            	    }
            	    break;
            	case 6 :
            	    // InternalOBJ.g:827:3: kw= '\\\\'
            	    {
            	    kw=(Token)match(input,24,FOLLOW_22); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getReverseSolidusKeyword_5());
            	    		

            	    }
            	    break;
            	case 7 :
            	    // InternalOBJ.g:833:3: kw= ':'
            	    {
            	    kw=(Token)match(input,25,FOLLOW_22); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getColonKeyword_6());
            	    		

            	    }
            	    break;
            	case 8 :
            	    // InternalOBJ.g:839:3: kw= '_'
            	    {
            	    kw=(Token)match(input,26,FOLLOW_22); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().get_Keyword_7());
            	    		

            	    }
            	    break;
            	case 9 :
            	    // InternalOBJ.g:845:3: kw= '-'
            	    {
            	    kw=(Token)match(input,22,FOLLOW_22); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getHyphenMinusKeyword_8());
            	    		

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
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


    // $ANTLR start "entryRuleEDouble"
    // InternalOBJ.g:854:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalOBJ.g:854:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalOBJ.g:855:2: iv_ruleEDouble= ruleEDouble EOF
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
    // InternalOBJ.g:861:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_0=null;
        AntlrDatatypeRuleToken this_EInt_1 = null;



        	enterRule();

        try {
            // InternalOBJ.g:867:2: ( (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt ) )
            // InternalOBJ.g:868:2: (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt )
            {
            // InternalOBJ.g:868:2: (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_DOUBLE) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_INT||LA18_0==22) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalOBJ.g:869:3: this_DOUBLE_0= RULE_DOUBLE
                    {
                    this_DOUBLE_0=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

                    			current.merge(this_DOUBLE_0);
                    		

                    			newLeafNode(this_DOUBLE_0, grammarAccess.getEDoubleAccess().getDOUBLETerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOBJ.g:877:3: this_EInt_1= ruleEInt
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

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String dfa_1s = "\30\uffff";
    static final String dfa_2s = "\1\1\27\uffff";
    static final String dfa_3s = "\1\14\1\uffff\2\4\2\uffff\22\4";
    static final String dfa_4s = "\1\23\1\uffff\2\32\2\uffff\22\32";
    static final String dfa_5s = "\1\uffff\1\3\2\uffff\1\1\1\2\22\uffff";
    static final String dfa_6s = "\30\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\1\3\3\4\3\5",
            "",
            "\1\10\1\6\1\7\16\uffff\1\12\1\16\1\11\1\13\1\14\1\15",
            "\1\21\1\17\1\20\7\uffff\3\4\3\5\1\uffff\1\23\1\27\1\22\1\24\1\25\1\26",
            "",
            "",
            "\1\10\1\6\1\7\5\uffff\1\2\1\3\3\4\3\5\1\uffff\1\12\1\16\1\11\1\13\1\14\1\15",
            "\1\10\1\6\1\7\5\uffff\1\2\1\3\3\4\3\5\1\uffff\1\12\1\16\1\11\1\13\1\14\1\15",
            "\1\10\1\6\1\7\5\uffff\1\2\1\3\3\4\3\5\1\uffff\1\12\1\16\1\11\1\13\1\14\1\15",
            "\1\10\1\6\1\7\5\uffff\1\2\1\3\3\4\3\5\1\uffff\1\12\1\16\1\11\1\13\1\14\1\15",
            "\1\10\1\6\1\7\5\uffff\1\2\1\3\3\4\3\5\1\uffff\1\12\1\16\1\11\1\13\1\14\1\15",
            "\1\10\1\6\1\7\5\uffff\1\2\1\3\3\4\3\5\1\uffff\1\12\1\16\1\11\1\13\1\14\1\15",
            "\1\10\1\6\1\7\5\uffff\1\2\1\3\3\4\3\5\1\uffff\1\12\1\16\1\11\1\13\1\14\1\15",
            "\1\10\1\6\1\7\5\uffff\1\2\1\3\3\4\3\5\1\uffff\1\12\1\16\1\11\1\13\1\14\1\15",
            "\1\10\1\6\1\7\5\uffff\1\2\1\3\3\4\3\5\1\uffff\1\12\1\16\1\11\1\13\1\14\1\15",
            "\1\21\1\17\1\20\7\uffff\3\4\3\5\1\uffff\1\23\1\27\1\22\1\24\1\25\1\26",
            "\1\21\1\17\1\20\7\uffff\3\4\3\5\1\uffff\1\23\1\27\1\22\1\24\1\25\1\26",
            "\1\21\1\17\1\20\7\uffff\3\4\3\5\1\uffff\1\23\1\27\1\22\1\24\1\25\1\26",
            "\1\21\1\17\1\20\7\uffff\3\4\3\5\1\uffff\1\23\1\27\1\22\1\24\1\25\1\26",
            "\1\21\1\17\1\20\7\uffff\3\4\3\5\1\uffff\1\23\1\27\1\22\1\24\1\25\1\26",
            "\1\21\1\17\1\20\7\uffff\3\4\3\5\1\uffff\1\23\1\27\1\22\1\24\1\25\1\26",
            "\1\21\1\17\1\20\7\uffff\3\4\3\5\1\uffff\1\23\1\27\1\22\1\24\1\25\1\26",
            "\1\21\1\17\1\20\7\uffff\3\4\3\5\1\uffff\1\23\1\27\1\22\1\24\1\25\1\26",
            "\1\21\1\17\1\20\7\uffff\3\4\3\5\1\uffff\1\23\1\27\1\22\1\24\1\25\1\26"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 78:2: ( ( (lv_vertexSources_0_0= ruleVertexSource ) ) | ( (lv_nodes_1_0= rulePolyShape ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000FF002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000007E00070L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000001F000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000007E1C070L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000400090L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000000000001C002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000000E3000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000007EE0070L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000000004C0090L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000500090L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000600092L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000600090L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000400092L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000007E00072L});

}