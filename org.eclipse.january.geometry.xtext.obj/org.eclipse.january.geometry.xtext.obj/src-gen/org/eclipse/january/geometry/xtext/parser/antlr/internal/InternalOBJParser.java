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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NORMAL", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_DOUBLE", "RULE_COMMENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'g'", "'v'", "'vt'", "'f'", "'/'", "'-'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int RULE_DOUBLE=8;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=7;
    public static final int RULE_NORMAL=4;
    public static final int RULE_WS=12;
    public static final int RULE_COMMENT=9;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=10;

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
    // InternalOBJ.g:71:1: ruleGeometry returns [EObject current=null] : ( ( (lv_vertexSource_0_0= ruleVertexSource ) )? ( (lv_nodes_1_0= rulePolyShape ) )* ) ;
    public final EObject ruleGeometry() throws RecognitionException {
        EObject current = null;

        EObject lv_vertexSource_0_0 = null;

        EObject lv_nodes_1_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:77:2: ( ( ( (lv_vertexSource_0_0= ruleVertexSource ) )? ( (lv_nodes_1_0= rulePolyShape ) )* ) )
            // InternalOBJ.g:78:2: ( ( (lv_vertexSource_0_0= ruleVertexSource ) )? ( (lv_nodes_1_0= rulePolyShape ) )* )
            {
            // InternalOBJ.g:78:2: ( ( (lv_vertexSource_0_0= ruleVertexSource ) )? ( (lv_nodes_1_0= rulePolyShape ) )* )
            // InternalOBJ.g:79:3: ( (lv_vertexSource_0_0= ruleVertexSource ) )? ( (lv_nodes_1_0= rulePolyShape ) )*
            {
            // InternalOBJ.g:79:3: ( (lv_vertexSource_0_0= ruleVertexSource ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)) ) {
                alt1=1;
            }
            else if ( (LA1_0==14) ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==RULE_STRING) ) {
                    alt1=1;
                }
                else if ( (LA1_2==EOF||LA1_2==RULE_NORMAL||LA1_2==RULE_ID||(LA1_2>=14 && LA1_2<=16)) ) {
                    alt1=1;
                }
            }
            switch (alt1) {
                case 1 :
                    // InternalOBJ.g:80:4: (lv_vertexSource_0_0= ruleVertexSource )
                    {
                    // InternalOBJ.g:80:4: (lv_vertexSource_0_0= ruleVertexSource )
                    // InternalOBJ.g:81:5: lv_vertexSource_0_0= ruleVertexSource
                    {

                    					newCompositeNode(grammarAccess.getGeometryAccess().getVertexSourceVertexSourceParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_3);
                    lv_vertexSource_0_0=ruleVertexSource();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getGeometryRule());
                    					}
                    					set(
                    						current,
                    						"vertexSource",
                    						lv_vertexSource_0_0,
                    						"org.eclipse.january.geometry.xtext.OBJ.VertexSource");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalOBJ.g:98:3: ( (lv_nodes_1_0= rulePolyShape ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalOBJ.g:99:4: (lv_nodes_1_0= rulePolyShape )
            	    {
            	    // InternalOBJ.g:99:4: (lv_nodes_1_0= rulePolyShape )
            	    // InternalOBJ.g:100:5: lv_nodes_1_0= rulePolyShape
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
            	    break;

            	default :
            	    break loop2;
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
    // InternalOBJ.g:121:1: entryRuleVertexSource returns [EObject current=null] : iv_ruleVertexSource= ruleVertexSource EOF ;
    public final EObject entryRuleVertexSource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVertexSource = null;


        try {
            // InternalOBJ.g:121:53: (iv_ruleVertexSource= ruleVertexSource EOF )
            // InternalOBJ.g:122:2: iv_ruleVertexSource= ruleVertexSource EOF
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
    // InternalOBJ.g:128:1: ruleVertexSource returns [EObject current=null] : ( () ( (lv_materialFiles_1_0= ruleEString ) )* otherlv_2= 'g' ( ruleEString )? ( (otherlv_4= 'v' ( (lv_vertices_5_0= ruleVertex ) ) ) | (otherlv_6= 'vt' ( (lv_textureCoordinates_7_0= ruleTextureVertex ) ) ) | this_NORMAL_8= RULE_NORMAL )* ) ;
    public final EObject ruleVertexSource() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_NORMAL_8=null;
        AntlrDatatypeRuleToken lv_materialFiles_1_0 = null;

        EObject lv_vertices_5_0 = null;

        EObject lv_textureCoordinates_7_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:134:2: ( ( () ( (lv_materialFiles_1_0= ruleEString ) )* otherlv_2= 'g' ( ruleEString )? ( (otherlv_4= 'v' ( (lv_vertices_5_0= ruleVertex ) ) ) | (otherlv_6= 'vt' ( (lv_textureCoordinates_7_0= ruleTextureVertex ) ) ) | this_NORMAL_8= RULE_NORMAL )* ) )
            // InternalOBJ.g:135:2: ( () ( (lv_materialFiles_1_0= ruleEString ) )* otherlv_2= 'g' ( ruleEString )? ( (otherlv_4= 'v' ( (lv_vertices_5_0= ruleVertex ) ) ) | (otherlv_6= 'vt' ( (lv_textureCoordinates_7_0= ruleTextureVertex ) ) ) | this_NORMAL_8= RULE_NORMAL )* )
            {
            // InternalOBJ.g:135:2: ( () ( (lv_materialFiles_1_0= ruleEString ) )* otherlv_2= 'g' ( ruleEString )? ( (otherlv_4= 'v' ( (lv_vertices_5_0= ruleVertex ) ) ) | (otherlv_6= 'vt' ( (lv_textureCoordinates_7_0= ruleTextureVertex ) ) ) | this_NORMAL_8= RULE_NORMAL )* )
            // InternalOBJ.g:136:3: () ( (lv_materialFiles_1_0= ruleEString ) )* otherlv_2= 'g' ( ruleEString )? ( (otherlv_4= 'v' ( (lv_vertices_5_0= ruleVertex ) ) ) | (otherlv_6= 'vt' ( (lv_textureCoordinates_7_0= ruleTextureVertex ) ) ) | this_NORMAL_8= RULE_NORMAL )*
            {
            // InternalOBJ.g:136:3: ()
            // InternalOBJ.g:137:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVertexSourceAccess().getVertexSourceAction_0(),
            					current);
            			

            }

            // InternalOBJ.g:143:3: ( (lv_materialFiles_1_0= ruleEString ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_ID)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalOBJ.g:144:4: (lv_materialFiles_1_0= ruleEString )
            	    {
            	    // InternalOBJ.g:144:4: (lv_materialFiles_1_0= ruleEString )
            	    // InternalOBJ.g:145:5: lv_materialFiles_1_0= ruleEString
            	    {

            	    					newCompositeNode(grammarAccess.getVertexSourceAccess().getMaterialFilesEStringParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_materialFiles_1_0=ruleEString();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getVertexSourceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"materialFiles",
            	    						lv_materialFiles_1_0,
            	    						"org.eclipse.january.geometry.xtext.OBJ.EString");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_2=(Token)match(input,14,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getVertexSourceAccess().getGKeyword_2());
            		
            // InternalOBJ.g:166:3: ( ruleEString )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_STRING && LA4_0<=RULE_ID)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalOBJ.g:167:4: ruleEString
                    {

                    				newCompositeNode(grammarAccess.getVertexSourceAccess().getEStringParserRuleCall_3());
                    			
                    pushFollow(FOLLOW_6);
                    ruleEString();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalOBJ.g:175:3: ( (otherlv_4= 'v' ( (lv_vertices_5_0= ruleVertex ) ) ) | (otherlv_6= 'vt' ( (lv_textureCoordinates_7_0= ruleTextureVertex ) ) ) | this_NORMAL_8= RULE_NORMAL )*
            loop5:
            do {
                int alt5=4;
                switch ( input.LA(1) ) {
                case 15:
                    {
                    alt5=1;
                    }
                    break;
                case 16:
                    {
                    alt5=2;
                    }
                    break;
                case RULE_NORMAL:
                    {
                    alt5=3;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // InternalOBJ.g:176:4: (otherlv_4= 'v' ( (lv_vertices_5_0= ruleVertex ) ) )
            	    {
            	    // InternalOBJ.g:176:4: (otherlv_4= 'v' ( (lv_vertices_5_0= ruleVertex ) ) )
            	    // InternalOBJ.g:177:5: otherlv_4= 'v' ( (lv_vertices_5_0= ruleVertex ) )
            	    {
            	    otherlv_4=(Token)match(input,15,FOLLOW_7); 

            	    					newLeafNode(otherlv_4, grammarAccess.getVertexSourceAccess().getVKeyword_4_0_0());
            	    				
            	    // InternalOBJ.g:181:5: ( (lv_vertices_5_0= ruleVertex ) )
            	    // InternalOBJ.g:182:6: (lv_vertices_5_0= ruleVertex )
            	    {
            	    // InternalOBJ.g:182:6: (lv_vertices_5_0= ruleVertex )
            	    // InternalOBJ.g:183:7: lv_vertices_5_0= ruleVertex
            	    {

            	    							newCompositeNode(grammarAccess.getVertexSourceAccess().getVerticesVertexParserRuleCall_4_0_1_0());
            	    						
            	    pushFollow(FOLLOW_6);
            	    lv_vertices_5_0=ruleVertex();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getVertexSourceRule());
            	    							}
            	    							add(
            	    								current,
            	    								"vertices",
            	    								lv_vertices_5_0,
            	    								"org.eclipse.january.geometry.xtext.OBJ.Vertex");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOBJ.g:202:4: (otherlv_6= 'vt' ( (lv_textureCoordinates_7_0= ruleTextureVertex ) ) )
            	    {
            	    // InternalOBJ.g:202:4: (otherlv_6= 'vt' ( (lv_textureCoordinates_7_0= ruleTextureVertex ) ) )
            	    // InternalOBJ.g:203:5: otherlv_6= 'vt' ( (lv_textureCoordinates_7_0= ruleTextureVertex ) )
            	    {
            	    otherlv_6=(Token)match(input,16,FOLLOW_7); 

            	    					newLeafNode(otherlv_6, grammarAccess.getVertexSourceAccess().getVtKeyword_4_1_0());
            	    				
            	    // InternalOBJ.g:207:5: ( (lv_textureCoordinates_7_0= ruleTextureVertex ) )
            	    // InternalOBJ.g:208:6: (lv_textureCoordinates_7_0= ruleTextureVertex )
            	    {
            	    // InternalOBJ.g:208:6: (lv_textureCoordinates_7_0= ruleTextureVertex )
            	    // InternalOBJ.g:209:7: lv_textureCoordinates_7_0= ruleTextureVertex
            	    {

            	    							newCompositeNode(grammarAccess.getVertexSourceAccess().getTextureCoordinatesTextureVertexParserRuleCall_4_1_1_0());
            	    						
            	    pushFollow(FOLLOW_6);
            	    lv_textureCoordinates_7_0=ruleTextureVertex();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getVertexSourceRule());
            	    							}
            	    							add(
            	    								current,
            	    								"textureCoordinates",
            	    								lv_textureCoordinates_7_0,
            	    								"org.eclipse.january.geometry.xtext.OBJ.TextureVertex");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOBJ.g:228:4: this_NORMAL_8= RULE_NORMAL
            	    {
            	    this_NORMAL_8=(Token)match(input,RULE_NORMAL,FOLLOW_6); 

            	    				newLeafNode(this_NORMAL_8, grammarAccess.getVertexSourceAccess().getNORMALTerminalRuleCall_4_2());
            	    			

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
    // $ANTLR end "ruleVertexSource"


    // $ANTLR start "entryRulePolyShape"
    // InternalOBJ.g:237:1: entryRulePolyShape returns [EObject current=null] : iv_rulePolyShape= rulePolyShape EOF ;
    public final EObject entryRulePolyShape() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePolyShape = null;


        try {
            // InternalOBJ.g:237:50: (iv_rulePolyShape= rulePolyShape EOF )
            // InternalOBJ.g:238:2: iv_rulePolyShape= rulePolyShape EOF
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
    // InternalOBJ.g:244:1: rulePolyShape returns [EObject current=null] : (otherlv_0= 'g' ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'f' ( (lv_faces_3_0= ruleFace ) ) )* ) ;
    public final EObject rulePolyShape() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_faces_3_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:250:2: ( (otherlv_0= 'g' ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'f' ( (lv_faces_3_0= ruleFace ) ) )* ) )
            // InternalOBJ.g:251:2: (otherlv_0= 'g' ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'f' ( (lv_faces_3_0= ruleFace ) ) )* )
            {
            // InternalOBJ.g:251:2: (otherlv_0= 'g' ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'f' ( (lv_faces_3_0= ruleFace ) ) )* )
            // InternalOBJ.g:252:3: otherlv_0= 'g' ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'f' ( (lv_faces_3_0= ruleFace ) ) )*
            {
            otherlv_0=(Token)match(input,14,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getPolyShapeAccess().getGKeyword_0());
            		
            // InternalOBJ.g:256:3: ( (lv_name_1_0= ruleEString ) )
            // InternalOBJ.g:257:4: (lv_name_1_0= ruleEString )
            {
            // InternalOBJ.g:257:4: (lv_name_1_0= ruleEString )
            // InternalOBJ.g:258:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPolyShapeAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_8);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPolyShapeRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.january.geometry.xtext.OBJ.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOBJ.g:275:3: (otherlv_2= 'f' ( (lv_faces_3_0= ruleFace ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalOBJ.g:276:4: otherlv_2= 'f' ( (lv_faces_3_0= ruleFace ) )
            	    {
            	    otherlv_2=(Token)match(input,17,FOLLOW_9); 

            	    				newLeafNode(otherlv_2, grammarAccess.getPolyShapeAccess().getFKeyword_2_0());
            	    			
            	    // InternalOBJ.g:280:4: ( (lv_faces_3_0= ruleFace ) )
            	    // InternalOBJ.g:281:5: (lv_faces_3_0= ruleFace )
            	    {
            	    // InternalOBJ.g:281:5: (lv_faces_3_0= ruleFace )
            	    // InternalOBJ.g:282:6: lv_faces_3_0= ruleFace
            	    {

            	    						newCompositeNode(grammarAccess.getPolyShapeAccess().getFacesFaceParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_8);
            	    lv_faces_3_0=ruleFace();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPolyShapeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"faces",
            	    							lv_faces_3_0,
            	    							"org.eclipse.january.geometry.xtext.OBJ.Face");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end "rulePolyShape"


    // $ANTLR start "entryRuleFace"
    // InternalOBJ.g:304:1: entryRuleFace returns [EObject current=null] : iv_ruleFace= ruleFace EOF ;
    public final EObject entryRuleFace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFace = null;


        try {
            // InternalOBJ.g:304:45: (iv_ruleFace= ruleFace EOF )
            // InternalOBJ.g:305:2: iv_ruleFace= ruleFace EOF
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
    // InternalOBJ.g:311:1: ruleFace returns [EObject current=null] : ( () ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )* ) ;
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
            // InternalOBJ.g:317:2: ( ( () ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )* ) )
            // InternalOBJ.g:318:2: ( () ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )* )
            {
            // InternalOBJ.g:318:2: ( () ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )* )
            // InternalOBJ.g:319:3: () ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )*
            {
            // InternalOBJ.g:319:3: ()
            // InternalOBJ.g:320:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFaceAccess().getFaceAction_0(),
            					current);
            			

            }

            // InternalOBJ.g:326:3: ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_INT||LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalOBJ.g:327:4: ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )?
            	    {
            	    // InternalOBJ.g:327:4: ( (lv_vertexIndices_1_0= ruleEInt ) )
            	    // InternalOBJ.g:328:5: (lv_vertexIndices_1_0= ruleEInt )
            	    {
            	    // InternalOBJ.g:328:5: (lv_vertexIndices_1_0= ruleEInt )
            	    // InternalOBJ.g:329:6: lv_vertexIndices_1_0= ruleEInt
            	    {

            	    						newCompositeNode(grammarAccess.getFaceAccess().getVertexIndicesEIntParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_10);
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

            	    // InternalOBJ.g:346:4: (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )?
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==18) ) {
            	        alt8=1;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // InternalOBJ.g:347:5: otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) )
            	            {
            	            otherlv_2=(Token)match(input,18,FOLLOW_11); 

            	            					newLeafNode(otherlv_2, grammarAccess.getFaceAccess().getSolidusKeyword_1_1_0());
            	            				
            	            // InternalOBJ.g:351:5: ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) )
            	            int alt7=3;
            	            switch ( input.LA(1) ) {
            	            case 19:
            	                {
            	                int LA7_1 = input.LA(2);

            	                if ( (LA7_1==RULE_INT) ) {
            	                    int LA7_2 = input.LA(3);

            	                    if ( (LA7_2==EOF||LA7_2==RULE_INT||LA7_2==14||LA7_2==17||LA7_2==19) ) {
            	                        alt7=1;
            	                    }
            	                    else if ( (LA7_2==18) ) {
            	                        alt7=2;
            	                    }
            	                    else {
            	                        NoViableAltException nvae =
            	                            new NoViableAltException("", 7, 2, input);

            	                        throw nvae;
            	                    }
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("", 7, 1, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case RULE_INT:
            	                {
            	                int LA7_2 = input.LA(2);

            	                if ( (LA7_2==EOF||LA7_2==RULE_INT||LA7_2==14||LA7_2==17||LA7_2==19) ) {
            	                    alt7=1;
            	                }
            	                else if ( (LA7_2==18) ) {
            	                    alt7=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("", 7, 2, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 18:
            	                {
            	                alt7=3;
            	                }
            	                break;
            	            default:
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 7, 0, input);

            	                throw nvae;
            	            }

            	            switch (alt7) {
            	                case 1 :
            	                    // InternalOBJ.g:352:6: ( (lv_textureIndices_3_0= ruleEInt ) )
            	                    {
            	                    // InternalOBJ.g:352:6: ( (lv_textureIndices_3_0= ruleEInt ) )
            	                    // InternalOBJ.g:353:7: (lv_textureIndices_3_0= ruleEInt )
            	                    {
            	                    // InternalOBJ.g:353:7: (lv_textureIndices_3_0= ruleEInt )
            	                    // InternalOBJ.g:354:8: lv_textureIndices_3_0= ruleEInt
            	                    {

            	                    								newCompositeNode(grammarAccess.getFaceAccess().getTextureIndicesEIntParserRuleCall_1_1_1_0_0());
            	                    							
            	                    pushFollow(FOLLOW_12);
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
            	                    // InternalOBJ.g:372:6: ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt )
            	                    {
            	                    // InternalOBJ.g:372:6: ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt )
            	                    // InternalOBJ.g:373:7: ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt
            	                    {
            	                    // InternalOBJ.g:373:7: ( (lv_textureIndices_4_0= ruleEInt ) )
            	                    // InternalOBJ.g:374:8: (lv_textureIndices_4_0= ruleEInt )
            	                    {
            	                    // InternalOBJ.g:374:8: (lv_textureIndices_4_0= ruleEInt )
            	                    // InternalOBJ.g:375:9: lv_textureIndices_4_0= ruleEInt
            	                    {

            	                    									newCompositeNode(grammarAccess.getFaceAccess().getTextureIndicesEIntParserRuleCall_1_1_1_1_0_0());
            	                    								
            	                    pushFollow(FOLLOW_13);
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

            	                    otherlv_5=(Token)match(input,18,FOLLOW_7); 

            	                    							newLeafNode(otherlv_5, grammarAccess.getFaceAccess().getSolidusKeyword_1_1_1_1_1());
            	                    						

            	                    							newCompositeNode(grammarAccess.getFaceAccess().getEIntParserRuleCall_1_1_1_1_2());
            	                    						
            	                    pushFollow(FOLLOW_12);
            	                    ruleEInt();

            	                    state._fsp--;


            	                    							afterParserOrEnumRuleCall();
            	                    						

            	                    }


            	                    }
            	                    break;
            	                case 3 :
            	                    // InternalOBJ.g:405:6: (otherlv_7= '/' ruleEInt )
            	                    {
            	                    // InternalOBJ.g:405:6: (otherlv_7= '/' ruleEInt )
            	                    // InternalOBJ.g:406:7: otherlv_7= '/' ruleEInt
            	                    {
            	                    otherlv_7=(Token)match(input,18,FOLLOW_7); 

            	                    							newLeafNode(otherlv_7, grammarAccess.getFaceAccess().getSolidusKeyword_1_1_1_2_0());
            	                    						

            	                    							newCompositeNode(grammarAccess.getFaceAccess().getEIntParserRuleCall_1_1_1_2_1());
            	                    						
            	                    pushFollow(FOLLOW_12);
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
            	    break loop9;
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
    // InternalOBJ.g:425:1: entryRuleVertex returns [EObject current=null] : iv_ruleVertex= ruleVertex EOF ;
    public final EObject entryRuleVertex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVertex = null;


        try {
            // InternalOBJ.g:425:47: (iv_ruleVertex= ruleVertex EOF )
            // InternalOBJ.g:426:2: iv_ruleVertex= ruleVertex EOF
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
    // InternalOBJ.g:432:1: ruleVertex returns [EObject current=null] : ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) ) ;
    public final EObject ruleVertex() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_x_1_0 = null;

        AntlrDatatypeRuleToken lv_y_2_0 = null;

        AntlrDatatypeRuleToken lv_z_3_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:438:2: ( ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) ) )
            // InternalOBJ.g:439:2: ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) )
            {
            // InternalOBJ.g:439:2: ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) )
            // InternalOBJ.g:440:3: () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) )
            {
            // InternalOBJ.g:440:3: ()
            // InternalOBJ.g:441:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVertexAccess().getVertexAction_0(),
            					current);
            			

            }

            // InternalOBJ.g:447:3: ( (lv_x_1_0= ruleEDouble ) )
            // InternalOBJ.g:448:4: (lv_x_1_0= ruleEDouble )
            {
            // InternalOBJ.g:448:4: (lv_x_1_0= ruleEDouble )
            // InternalOBJ.g:449:5: lv_x_1_0= ruleEDouble
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
            						"org.eclipse.january.geometry.xtext.OBJ.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOBJ.g:466:3: ( (lv_y_2_0= ruleEDouble ) )
            // InternalOBJ.g:467:4: (lv_y_2_0= ruleEDouble )
            {
            // InternalOBJ.g:467:4: (lv_y_2_0= ruleEDouble )
            // InternalOBJ.g:468:5: lv_y_2_0= ruleEDouble
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
            						"org.eclipse.january.geometry.xtext.OBJ.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOBJ.g:485:3: ( (lv_z_3_0= ruleEDouble ) )
            // InternalOBJ.g:486:4: (lv_z_3_0= ruleEDouble )
            {
            // InternalOBJ.g:486:4: (lv_z_3_0= ruleEDouble )
            // InternalOBJ.g:487:5: lv_z_3_0= ruleEDouble
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
    // InternalOBJ.g:508:1: entryRuleTextureVertex returns [EObject current=null] : iv_ruleTextureVertex= ruleTextureVertex EOF ;
    public final EObject entryRuleTextureVertex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextureVertex = null;


        try {
            // InternalOBJ.g:508:54: (iv_ruleTextureVertex= ruleTextureVertex EOF )
            // InternalOBJ.g:509:2: iv_ruleTextureVertex= ruleTextureVertex EOF
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
    // InternalOBJ.g:515:1: ruleTextureVertex returns [EObject current=null] : ( ( (lv_x_0_0= ruleEDouble ) ) ( (lv_y_1_0= ruleEDouble ) ) ( (lv_z_2_0= ruleEDouble ) )? ) ;
    public final EObject ruleTextureVertex() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_x_0_0 = null;

        AntlrDatatypeRuleToken lv_y_1_0 = null;

        AntlrDatatypeRuleToken lv_z_2_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:521:2: ( ( ( (lv_x_0_0= ruleEDouble ) ) ( (lv_y_1_0= ruleEDouble ) ) ( (lv_z_2_0= ruleEDouble ) )? ) )
            // InternalOBJ.g:522:2: ( ( (lv_x_0_0= ruleEDouble ) ) ( (lv_y_1_0= ruleEDouble ) ) ( (lv_z_2_0= ruleEDouble ) )? )
            {
            // InternalOBJ.g:522:2: ( ( (lv_x_0_0= ruleEDouble ) ) ( (lv_y_1_0= ruleEDouble ) ) ( (lv_z_2_0= ruleEDouble ) )? )
            // InternalOBJ.g:523:3: ( (lv_x_0_0= ruleEDouble ) ) ( (lv_y_1_0= ruleEDouble ) ) ( (lv_z_2_0= ruleEDouble ) )?
            {
            // InternalOBJ.g:523:3: ( (lv_x_0_0= ruleEDouble ) )
            // InternalOBJ.g:524:4: (lv_x_0_0= ruleEDouble )
            {
            // InternalOBJ.g:524:4: (lv_x_0_0= ruleEDouble )
            // InternalOBJ.g:525:5: lv_x_0_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getTextureVertexAccess().getXEDoubleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
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

            // InternalOBJ.g:542:3: ( (lv_y_1_0= ruleEDouble ) )
            // InternalOBJ.g:543:4: (lv_y_1_0= ruleEDouble )
            {
            // InternalOBJ.g:543:4: (lv_y_1_0= ruleEDouble )
            // InternalOBJ.g:544:5: lv_y_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getTextureVertexAccess().getYEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_12);
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

            // InternalOBJ.g:561:3: ( (lv_z_2_0= ruleEDouble ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_INT||LA10_0==RULE_DOUBLE||LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalOBJ.g:562:4: (lv_z_2_0= ruleEDouble )
                    {
                    // InternalOBJ.g:562:4: (lv_z_2_0= ruleEDouble )
                    // InternalOBJ.g:563:5: lv_z_2_0= ruleEDouble
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


    // $ANTLR start "entryRuleEInt"
    // InternalOBJ.g:584:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalOBJ.g:584:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalOBJ.g:585:2: iv_ruleEInt= ruleEInt EOF
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
    // InternalOBJ.g:591:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalOBJ.g:597:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalOBJ.g:598:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalOBJ.g:598:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalOBJ.g:599:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalOBJ.g:599:3: (kw= '-' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalOBJ.g:600:4: kw= '-'
                    {
                    kw=(Token)match(input,19,FOLLOW_14); 

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
    // InternalOBJ.g:617:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalOBJ.g:617:47: (iv_ruleEString= ruleEString EOF )
            // InternalOBJ.g:618:2: iv_ruleEString= ruleEString EOF
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
    // InternalOBJ.g:624:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalOBJ.g:630:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalOBJ.g:631:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalOBJ.g:631:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_STRING) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalOBJ.g:632:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOBJ.g:640:3: this_ID_1= RULE_ID
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


    // $ANTLR start "entryRuleEDouble"
    // InternalOBJ.g:651:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalOBJ.g:651:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalOBJ.g:652:2: iv_ruleEDouble= ruleEDouble EOF
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
    // InternalOBJ.g:658:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_0=null;
        AntlrDatatypeRuleToken this_EInt_1 = null;



        	enterRule();

        try {
            // InternalOBJ.g:664:2: ( (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt ) )
            // InternalOBJ.g:665:2: (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt )
            {
            // InternalOBJ.g:665:2: (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_DOUBLE) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_INT||LA13_0==19) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalOBJ.g:666:3: this_DOUBLE_0= RULE_DOUBLE
                    {
                    this_DOUBLE_0=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

                    			current.merge(this_DOUBLE_0);
                    		

                    			newLeafNode(this_DOUBLE_0, grammarAccess.getEDoubleAccess().getDOUBLETerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOBJ.g:674:3: this_EInt_1= ruleEInt
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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000000040C0L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000001C0D2L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000018012L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000080120L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000A0120L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000000C0122L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000C0120L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080122L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000020L});

}