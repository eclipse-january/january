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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NORMAL", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_DOUBLE", "RULE_COMMENT", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'mtllib'", "'g'", "'v'", "'vt'", "'usemtl'", "'f'", "'s'", "'off'", "'/'", "'-'", "'.'", "'\\\\'", "':'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=12;
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
    public static final int RULE_WS=10;
    public static final int RULE_COMMENT=9;
    public static final int RULE_ANY_OTHER=13;
    public static final int T__26=26;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=11;
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
            alt1 = dfa1.predict(input);
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

                if ( (LA2_0==15||(LA2_0>=18 && LA2_0<=20)) ) {
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
    // InternalOBJ.g:128:1: ruleVertexSource returns [EObject current=null] : ( () (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )* (otherlv_3= 'g' ( ruleEString )? )? ( (otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) ) ) | (otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) ) ) | this_NORMAL_9= RULE_NORMAL )+ ) ;
    public final EObject ruleVertexSource() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token this_NORMAL_9=null;
        AntlrDatatypeRuleToken lv_materialFiles_2_0 = null;

        EObject lv_vertices_6_0 = null;

        EObject lv_textureCoordinates_8_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:134:2: ( ( () (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )* (otherlv_3= 'g' ( ruleEString )? )? ( (otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) ) ) | (otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) ) ) | this_NORMAL_9= RULE_NORMAL )+ ) )
            // InternalOBJ.g:135:2: ( () (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )* (otherlv_3= 'g' ( ruleEString )? )? ( (otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) ) ) | (otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) ) ) | this_NORMAL_9= RULE_NORMAL )+ )
            {
            // InternalOBJ.g:135:2: ( () (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )* (otherlv_3= 'g' ( ruleEString )? )? ( (otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) ) ) | (otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) ) ) | this_NORMAL_9= RULE_NORMAL )+ )
            // InternalOBJ.g:136:3: () (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )* (otherlv_3= 'g' ( ruleEString )? )? ( (otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) ) ) | (otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) ) ) | this_NORMAL_9= RULE_NORMAL )+
            {
            // InternalOBJ.g:136:3: ()
            // InternalOBJ.g:137:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVertexSourceAccess().getVertexSourceAction_0(),
            					current);
            			

            }

            // InternalOBJ.g:143:3: (otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalOBJ.g:144:4: otherlv_1= 'mtllib' ( (lv_materialFiles_2_0= ruleEString ) )
            	    {
            	    otherlv_1=(Token)match(input,14,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getVertexSourceAccess().getMtllibKeyword_1_0());
            	    			
            	    // InternalOBJ.g:148:4: ( (lv_materialFiles_2_0= ruleEString ) )
            	    // InternalOBJ.g:149:5: (lv_materialFiles_2_0= ruleEString )
            	    {
            	    // InternalOBJ.g:149:5: (lv_materialFiles_2_0= ruleEString )
            	    // InternalOBJ.g:150:6: lv_materialFiles_2_0= ruleEString
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
            	    break loop3;
                }
            } while (true);

            // InternalOBJ.g:168:3: (otherlv_3= 'g' ( ruleEString )? )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalOBJ.g:169:4: otherlv_3= 'g' ( ruleEString )?
                    {
                    otherlv_3=(Token)match(input,15,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getVertexSourceAccess().getGKeyword_2_0());
                    			
                    // InternalOBJ.g:173:4: ( ruleEString )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=RULE_STRING && LA4_0<=RULE_ID)||LA4_0==22||(LA4_0>=24 && LA4_0<=26)) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalOBJ.g:174:5: ruleEString
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

            // InternalOBJ.g:183:3: ( (otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) ) ) | (otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) ) ) | this_NORMAL_9= RULE_NORMAL )+
            int cnt6=0;
            loop6:
            do {
                int alt6=4;
                switch ( input.LA(1) ) {
                case 16:
                    {
                    alt6=1;
                    }
                    break;
                case 17:
                    {
                    alt6=2;
                    }
                    break;
                case RULE_NORMAL:
                    {
                    alt6=3;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // InternalOBJ.g:184:4: (otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) ) )
            	    {
            	    // InternalOBJ.g:184:4: (otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) ) )
            	    // InternalOBJ.g:185:5: otherlv_5= 'v' ( (lv_vertices_6_0= ruleVertex ) )
            	    {
            	    otherlv_5=(Token)match(input,16,FOLLOW_8); 

            	    					newLeafNode(otherlv_5, grammarAccess.getVertexSourceAccess().getVKeyword_3_0_0());
            	    				
            	    // InternalOBJ.g:189:5: ( (lv_vertices_6_0= ruleVertex ) )
            	    // InternalOBJ.g:190:6: (lv_vertices_6_0= ruleVertex )
            	    {
            	    // InternalOBJ.g:190:6: (lv_vertices_6_0= ruleVertex )
            	    // InternalOBJ.g:191:7: lv_vertices_6_0= ruleVertex
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
            	    // InternalOBJ.g:210:4: (otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) ) )
            	    {
            	    // InternalOBJ.g:210:4: (otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) ) )
            	    // InternalOBJ.g:211:5: otherlv_7= 'vt' ( (lv_textureCoordinates_8_0= ruleTextureVertex ) )
            	    {
            	    otherlv_7=(Token)match(input,17,FOLLOW_8); 

            	    					newLeafNode(otherlv_7, grammarAccess.getVertexSourceAccess().getVtKeyword_3_1_0());
            	    				
            	    // InternalOBJ.g:215:5: ( (lv_textureCoordinates_8_0= ruleTextureVertex ) )
            	    // InternalOBJ.g:216:6: (lv_textureCoordinates_8_0= ruleTextureVertex )
            	    {
            	    // InternalOBJ.g:216:6: (lv_textureCoordinates_8_0= ruleTextureVertex )
            	    // InternalOBJ.g:217:7: lv_textureCoordinates_8_0= ruleTextureVertex
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
            	    // InternalOBJ.g:236:4: this_NORMAL_9= RULE_NORMAL
            	    {
            	    this_NORMAL_9=(Token)match(input,RULE_NORMAL,FOLLOW_9); 

            	    				newLeafNode(this_NORMAL_9, grammarAccess.getVertexSourceAccess().getNORMALTerminalRuleCall_3_2());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
    // InternalOBJ.g:245:1: entryRulePolyShape returns [EObject current=null] : iv_rulePolyShape= rulePolyShape EOF ;
    public final EObject entryRulePolyShape() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePolyShape = null;


        try {
            // InternalOBJ.g:245:50: (iv_rulePolyShape= rulePolyShape EOF )
            // InternalOBJ.g:246:2: iv_rulePolyShape= rulePolyShape EOF
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
    // InternalOBJ.g:252:1: rulePolyShape returns [EObject current=null] : ( (otherlv_0= 'g' ( (lv_name_1_0= ruleEString ) ) )? (otherlv_2= 'usemtl' ( (lv_material_3_0= ruleMaterial ) ) )? ( (otherlv_4= 'f' ( (lv_faces_5_0= ruleFace ) ) ) | (otherlv_6= 's' ( ruleEInt | otherlv_8= 'off' ) ) )+ ) ;
    public final EObject rulePolyShape() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_material_3_0 = null;

        EObject lv_faces_5_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:258:2: ( ( (otherlv_0= 'g' ( (lv_name_1_0= ruleEString ) ) )? (otherlv_2= 'usemtl' ( (lv_material_3_0= ruleMaterial ) ) )? ( (otherlv_4= 'f' ( (lv_faces_5_0= ruleFace ) ) ) | (otherlv_6= 's' ( ruleEInt | otherlv_8= 'off' ) ) )+ ) )
            // InternalOBJ.g:259:2: ( (otherlv_0= 'g' ( (lv_name_1_0= ruleEString ) ) )? (otherlv_2= 'usemtl' ( (lv_material_3_0= ruleMaterial ) ) )? ( (otherlv_4= 'f' ( (lv_faces_5_0= ruleFace ) ) ) | (otherlv_6= 's' ( ruleEInt | otherlv_8= 'off' ) ) )+ )
            {
            // InternalOBJ.g:259:2: ( (otherlv_0= 'g' ( (lv_name_1_0= ruleEString ) ) )? (otherlv_2= 'usemtl' ( (lv_material_3_0= ruleMaterial ) ) )? ( (otherlv_4= 'f' ( (lv_faces_5_0= ruleFace ) ) ) | (otherlv_6= 's' ( ruleEInt | otherlv_8= 'off' ) ) )+ )
            // InternalOBJ.g:260:3: (otherlv_0= 'g' ( (lv_name_1_0= ruleEString ) ) )? (otherlv_2= 'usemtl' ( (lv_material_3_0= ruleMaterial ) ) )? ( (otherlv_4= 'f' ( (lv_faces_5_0= ruleFace ) ) ) | (otherlv_6= 's' ( ruleEInt | otherlv_8= 'off' ) ) )+
            {
            // InternalOBJ.g:260:3: (otherlv_0= 'g' ( (lv_name_1_0= ruleEString ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalOBJ.g:261:4: otherlv_0= 'g' ( (lv_name_1_0= ruleEString ) )
                    {
                    otherlv_0=(Token)match(input,15,FOLLOW_4); 

                    				newLeafNode(otherlv_0, grammarAccess.getPolyShapeAccess().getGKeyword_0_0());
                    			
                    // InternalOBJ.g:265:4: ( (lv_name_1_0= ruleEString ) )
                    // InternalOBJ.g:266:5: (lv_name_1_0= ruleEString )
                    {
                    // InternalOBJ.g:266:5: (lv_name_1_0= ruleEString )
                    // InternalOBJ.g:267:6: lv_name_1_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getPolyShapeAccess().getNameEStringParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_10);
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


                    }
                    break;

            }

            // InternalOBJ.g:285:3: (otherlv_2= 'usemtl' ( (lv_material_3_0= ruleMaterial ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalOBJ.g:286:4: otherlv_2= 'usemtl' ( (lv_material_3_0= ruleMaterial ) )
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getPolyShapeAccess().getUsemtlKeyword_1_0());
                    			
                    // InternalOBJ.g:290:4: ( (lv_material_3_0= ruleMaterial ) )
                    // InternalOBJ.g:291:5: (lv_material_3_0= ruleMaterial )
                    {
                    // InternalOBJ.g:291:5: (lv_material_3_0= ruleMaterial )
                    // InternalOBJ.g:292:6: lv_material_3_0= ruleMaterial
                    {

                    						newCompositeNode(grammarAccess.getPolyShapeAccess().getMaterialMaterialParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_material_3_0=ruleMaterial();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPolyShapeRule());
                    						}
                    						set(
                    							current,
                    							"material",
                    							lv_material_3_0,
                    							"org.eclipse.january.geometry.xtext.OBJ.Material");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOBJ.g:310:3: ( (otherlv_4= 'f' ( (lv_faces_5_0= ruleFace ) ) ) | (otherlv_6= 's' ( ruleEInt | otherlv_8= 'off' ) ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=3;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==19) ) {
                    alt10=1;
                }
                else if ( (LA10_0==20) ) {
                    alt10=2;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalOBJ.g:311:4: (otherlv_4= 'f' ( (lv_faces_5_0= ruleFace ) ) )
            	    {
            	    // InternalOBJ.g:311:4: (otherlv_4= 'f' ( (lv_faces_5_0= ruleFace ) ) )
            	    // InternalOBJ.g:312:5: otherlv_4= 'f' ( (lv_faces_5_0= ruleFace ) )
            	    {
            	    otherlv_4=(Token)match(input,19,FOLLOW_12); 

            	    					newLeafNode(otherlv_4, grammarAccess.getPolyShapeAccess().getFKeyword_2_0_0());
            	    				
            	    // InternalOBJ.g:316:5: ( (lv_faces_5_0= ruleFace ) )
            	    // InternalOBJ.g:317:6: (lv_faces_5_0= ruleFace )
            	    {
            	    // InternalOBJ.g:317:6: (lv_faces_5_0= ruleFace )
            	    // InternalOBJ.g:318:7: lv_faces_5_0= ruleFace
            	    {

            	    							newCompositeNode(grammarAccess.getPolyShapeAccess().getFacesFaceParserRuleCall_2_0_1_0());
            	    						
            	    pushFollow(FOLLOW_13);
            	    lv_faces_5_0=ruleFace();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getPolyShapeRule());
            	    							}
            	    							add(
            	    								current,
            	    								"faces",
            	    								lv_faces_5_0,
            	    								"org.eclipse.january.geometry.xtext.OBJ.Face");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOBJ.g:337:4: (otherlv_6= 's' ( ruleEInt | otherlv_8= 'off' ) )
            	    {
            	    // InternalOBJ.g:337:4: (otherlv_6= 's' ( ruleEInt | otherlv_8= 'off' ) )
            	    // InternalOBJ.g:338:5: otherlv_6= 's' ( ruleEInt | otherlv_8= 'off' )
            	    {
            	    otherlv_6=(Token)match(input,20,FOLLOW_14); 

            	    					newLeafNode(otherlv_6, grammarAccess.getPolyShapeAccess().getSKeyword_2_1_0());
            	    				
            	    // InternalOBJ.g:342:5: ( ruleEInt | otherlv_8= 'off' )
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==RULE_INT||LA9_0==23) ) {
            	        alt9=1;
            	    }
            	    else if ( (LA9_0==21) ) {
            	        alt9=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 9, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // InternalOBJ.g:343:6: ruleEInt
            	            {

            	            						newCompositeNode(grammarAccess.getPolyShapeAccess().getEIntParserRuleCall_2_1_1_0());
            	            					
            	            pushFollow(FOLLOW_13);
            	            ruleEInt();

            	            state._fsp--;


            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // InternalOBJ.g:351:6: otherlv_8= 'off'
            	            {
            	            otherlv_8=(Token)match(input,21,FOLLOW_13); 

            	            						newLeafNode(otherlv_8, grammarAccess.getPolyShapeAccess().getOffKeyword_2_1_1_1());
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
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
    // InternalOBJ.g:362:1: entryRuleFace returns [EObject current=null] : iv_ruleFace= ruleFace EOF ;
    public final EObject entryRuleFace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFace = null;


        try {
            // InternalOBJ.g:362:45: (iv_ruleFace= ruleFace EOF )
            // InternalOBJ.g:363:2: iv_ruleFace= ruleFace EOF
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
    // InternalOBJ.g:369:1: ruleFace returns [EObject current=null] : ( () ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )* ) ;
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
            // InternalOBJ.g:375:2: ( ( () ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )* ) )
            // InternalOBJ.g:376:2: ( () ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )* )
            {
            // InternalOBJ.g:376:2: ( () ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )* )
            // InternalOBJ.g:377:3: () ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )*
            {
            // InternalOBJ.g:377:3: ()
            // InternalOBJ.g:378:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFaceAccess().getFaceAction_0(),
            					current);
            			

            }

            // InternalOBJ.g:384:3: ( ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )? )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_INT||LA13_0==23) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalOBJ.g:385:4: ( (lv_vertexIndices_1_0= ruleEInt ) ) (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )?
            	    {
            	    // InternalOBJ.g:385:4: ( (lv_vertexIndices_1_0= ruleEInt ) )
            	    // InternalOBJ.g:386:5: (lv_vertexIndices_1_0= ruleEInt )
            	    {
            	    // InternalOBJ.g:386:5: (lv_vertexIndices_1_0= ruleEInt )
            	    // InternalOBJ.g:387:6: lv_vertexIndices_1_0= ruleEInt
            	    {

            	    						newCompositeNode(grammarAccess.getFaceAccess().getVertexIndicesEIntParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_15);
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

            	    // InternalOBJ.g:404:4: (otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) ) )?
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==22) ) {
            	        alt12=1;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // InternalOBJ.g:405:5: otherlv_2= '/' ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) )
            	            {
            	            otherlv_2=(Token)match(input,22,FOLLOW_16); 

            	            					newLeafNode(otherlv_2, grammarAccess.getFaceAccess().getSolidusKeyword_1_1_0());
            	            				
            	            // InternalOBJ.g:409:5: ( ( (lv_textureIndices_3_0= ruleEInt ) ) | ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt ) | (otherlv_7= '/' ruleEInt ) )
            	            int alt11=3;
            	            switch ( input.LA(1) ) {
            	            case 23:
            	                {
            	                int LA11_1 = input.LA(2);

            	                if ( (LA11_1==RULE_INT) ) {
            	                    int LA11_2 = input.LA(3);

            	                    if ( (LA11_2==EOF||LA11_2==RULE_INT||LA11_2==15||(LA11_2>=18 && LA11_2<=20)||LA11_2==23) ) {
            	                        alt11=1;
            	                    }
            	                    else if ( (LA11_2==22) ) {
            	                        alt11=2;
            	                    }
            	                    else {
            	                        NoViableAltException nvae =
            	                            new NoViableAltException("", 11, 2, input);

            	                        throw nvae;
            	                    }
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("", 11, 1, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case RULE_INT:
            	                {
            	                int LA11_2 = input.LA(2);

            	                if ( (LA11_2==EOF||LA11_2==RULE_INT||LA11_2==15||(LA11_2>=18 && LA11_2<=20)||LA11_2==23) ) {
            	                    alt11=1;
            	                }
            	                else if ( (LA11_2==22) ) {
            	                    alt11=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("", 11, 2, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 22:
            	                {
            	                alt11=3;
            	                }
            	                break;
            	            default:
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 11, 0, input);

            	                throw nvae;
            	            }

            	            switch (alt11) {
            	                case 1 :
            	                    // InternalOBJ.g:410:6: ( (lv_textureIndices_3_0= ruleEInt ) )
            	                    {
            	                    // InternalOBJ.g:410:6: ( (lv_textureIndices_3_0= ruleEInt ) )
            	                    // InternalOBJ.g:411:7: (lv_textureIndices_3_0= ruleEInt )
            	                    {
            	                    // InternalOBJ.g:411:7: (lv_textureIndices_3_0= ruleEInt )
            	                    // InternalOBJ.g:412:8: lv_textureIndices_3_0= ruleEInt
            	                    {

            	                    								newCompositeNode(grammarAccess.getFaceAccess().getTextureIndicesEIntParserRuleCall_1_1_1_0_0());
            	                    							
            	                    pushFollow(FOLLOW_17);
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
            	                    // InternalOBJ.g:430:6: ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt )
            	                    {
            	                    // InternalOBJ.g:430:6: ( ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt )
            	                    // InternalOBJ.g:431:7: ( (lv_textureIndices_4_0= ruleEInt ) ) otherlv_5= '/' ruleEInt
            	                    {
            	                    // InternalOBJ.g:431:7: ( (lv_textureIndices_4_0= ruleEInt ) )
            	                    // InternalOBJ.g:432:8: (lv_textureIndices_4_0= ruleEInt )
            	                    {
            	                    // InternalOBJ.g:432:8: (lv_textureIndices_4_0= ruleEInt )
            	                    // InternalOBJ.g:433:9: lv_textureIndices_4_0= ruleEInt
            	                    {

            	                    									newCompositeNode(grammarAccess.getFaceAccess().getTextureIndicesEIntParserRuleCall_1_1_1_1_0_0());
            	                    								
            	                    pushFollow(FOLLOW_18);
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

            	                    otherlv_5=(Token)match(input,22,FOLLOW_8); 

            	                    							newLeafNode(otherlv_5, grammarAccess.getFaceAccess().getSolidusKeyword_1_1_1_1_1());
            	                    						

            	                    							newCompositeNode(grammarAccess.getFaceAccess().getEIntParserRuleCall_1_1_1_1_2());
            	                    						
            	                    pushFollow(FOLLOW_17);
            	                    ruleEInt();

            	                    state._fsp--;


            	                    							afterParserOrEnumRuleCall();
            	                    						

            	                    }


            	                    }
            	                    break;
            	                case 3 :
            	                    // InternalOBJ.g:463:6: (otherlv_7= '/' ruleEInt )
            	                    {
            	                    // InternalOBJ.g:463:6: (otherlv_7= '/' ruleEInt )
            	                    // InternalOBJ.g:464:7: otherlv_7= '/' ruleEInt
            	                    {
            	                    otherlv_7=(Token)match(input,22,FOLLOW_8); 

            	                    							newLeafNode(otherlv_7, grammarAccess.getFaceAccess().getSolidusKeyword_1_1_1_2_0());
            	                    						

            	                    							newCompositeNode(grammarAccess.getFaceAccess().getEIntParserRuleCall_1_1_1_2_1());
            	                    						
            	                    pushFollow(FOLLOW_17);
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
            	    break loop13;
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
    // InternalOBJ.g:483:1: entryRuleVertex returns [EObject current=null] : iv_ruleVertex= ruleVertex EOF ;
    public final EObject entryRuleVertex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVertex = null;


        try {
            // InternalOBJ.g:483:47: (iv_ruleVertex= ruleVertex EOF )
            // InternalOBJ.g:484:2: iv_ruleVertex= ruleVertex EOF
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
    // InternalOBJ.g:490:1: ruleVertex returns [EObject current=null] : ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) ) ;
    public final EObject ruleVertex() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_x_1_0 = null;

        AntlrDatatypeRuleToken lv_y_2_0 = null;

        AntlrDatatypeRuleToken lv_z_3_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:496:2: ( ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) ) )
            // InternalOBJ.g:497:2: ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) )
            {
            // InternalOBJ.g:497:2: ( () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) ) )
            // InternalOBJ.g:498:3: () ( (lv_x_1_0= ruleEDouble ) ) ( (lv_y_2_0= ruleEDouble ) ) ( (lv_z_3_0= ruleEDouble ) )
            {
            // InternalOBJ.g:498:3: ()
            // InternalOBJ.g:499:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVertexAccess().getVertexAction_0(),
            					current);
            			

            }

            // InternalOBJ.g:505:3: ( (lv_x_1_0= ruleEDouble ) )
            // InternalOBJ.g:506:4: (lv_x_1_0= ruleEDouble )
            {
            // InternalOBJ.g:506:4: (lv_x_1_0= ruleEDouble )
            // InternalOBJ.g:507:5: lv_x_1_0= ruleEDouble
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

            // InternalOBJ.g:524:3: ( (lv_y_2_0= ruleEDouble ) )
            // InternalOBJ.g:525:4: (lv_y_2_0= ruleEDouble )
            {
            // InternalOBJ.g:525:4: (lv_y_2_0= ruleEDouble )
            // InternalOBJ.g:526:5: lv_y_2_0= ruleEDouble
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

            // InternalOBJ.g:543:3: ( (lv_z_3_0= ruleEDouble ) )
            // InternalOBJ.g:544:4: (lv_z_3_0= ruleEDouble )
            {
            // InternalOBJ.g:544:4: (lv_z_3_0= ruleEDouble )
            // InternalOBJ.g:545:5: lv_z_3_0= ruleEDouble
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
    // InternalOBJ.g:566:1: entryRuleTextureVertex returns [EObject current=null] : iv_ruleTextureVertex= ruleTextureVertex EOF ;
    public final EObject entryRuleTextureVertex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextureVertex = null;


        try {
            // InternalOBJ.g:566:54: (iv_ruleTextureVertex= ruleTextureVertex EOF )
            // InternalOBJ.g:567:2: iv_ruleTextureVertex= ruleTextureVertex EOF
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
    // InternalOBJ.g:573:1: ruleTextureVertex returns [EObject current=null] : ( ( (lv_x_0_0= ruleEDouble ) ) ( (lv_y_1_0= ruleEDouble ) ) ( (lv_z_2_0= ruleEDouble ) )? ) ;
    public final EObject ruleTextureVertex() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_x_0_0 = null;

        AntlrDatatypeRuleToken lv_y_1_0 = null;

        AntlrDatatypeRuleToken lv_z_2_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:579:2: ( ( ( (lv_x_0_0= ruleEDouble ) ) ( (lv_y_1_0= ruleEDouble ) ) ( (lv_z_2_0= ruleEDouble ) )? ) )
            // InternalOBJ.g:580:2: ( ( (lv_x_0_0= ruleEDouble ) ) ( (lv_y_1_0= ruleEDouble ) ) ( (lv_z_2_0= ruleEDouble ) )? )
            {
            // InternalOBJ.g:580:2: ( ( (lv_x_0_0= ruleEDouble ) ) ( (lv_y_1_0= ruleEDouble ) ) ( (lv_z_2_0= ruleEDouble ) )? )
            // InternalOBJ.g:581:3: ( (lv_x_0_0= ruleEDouble ) ) ( (lv_y_1_0= ruleEDouble ) ) ( (lv_z_2_0= ruleEDouble ) )?
            {
            // InternalOBJ.g:581:3: ( (lv_x_0_0= ruleEDouble ) )
            // InternalOBJ.g:582:4: (lv_x_0_0= ruleEDouble )
            {
            // InternalOBJ.g:582:4: (lv_x_0_0= ruleEDouble )
            // InternalOBJ.g:583:5: lv_x_0_0= ruleEDouble
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

            // InternalOBJ.g:600:3: ( (lv_y_1_0= ruleEDouble ) )
            // InternalOBJ.g:601:4: (lv_y_1_0= ruleEDouble )
            {
            // InternalOBJ.g:601:4: (lv_y_1_0= ruleEDouble )
            // InternalOBJ.g:602:5: lv_y_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getTextureVertexAccess().getYEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_17);
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

            // InternalOBJ.g:619:3: ( (lv_z_2_0= ruleEDouble ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_INT||LA14_0==RULE_DOUBLE||LA14_0==23) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalOBJ.g:620:4: (lv_z_2_0= ruleEDouble )
                    {
                    // InternalOBJ.g:620:4: (lv_z_2_0= ruleEDouble )
                    // InternalOBJ.g:621:5: lv_z_2_0= ruleEDouble
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
    // InternalOBJ.g:642:1: entryRuleMaterial returns [EObject current=null] : iv_ruleMaterial= ruleMaterial EOF ;
    public final EObject entryRuleMaterial() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaterial = null;


        try {
            // InternalOBJ.g:642:49: (iv_ruleMaterial= ruleMaterial EOF )
            // InternalOBJ.g:643:2: iv_ruleMaterial= ruleMaterial EOF
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
    // InternalOBJ.g:649:1: ruleMaterial returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) ) ;
    public final EObject ruleMaterial() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalOBJ.g:655:2: ( ( () ( (lv_name_1_0= ruleEString ) ) ) )
            // InternalOBJ.g:656:2: ( () ( (lv_name_1_0= ruleEString ) ) )
            {
            // InternalOBJ.g:656:2: ( () ( (lv_name_1_0= ruleEString ) ) )
            // InternalOBJ.g:657:3: () ( (lv_name_1_0= ruleEString ) )
            {
            // InternalOBJ.g:657:3: ()
            // InternalOBJ.g:658:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMaterialAccess().getMaterialAction_0(),
            					current);
            			

            }

            // InternalOBJ.g:664:3: ( (lv_name_1_0= ruleEString ) )
            // InternalOBJ.g:665:4: (lv_name_1_0= ruleEString )
            {
            // InternalOBJ.g:665:4: (lv_name_1_0= ruleEString )
            // InternalOBJ.g:666:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getMaterialAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMaterialRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
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
    // InternalOBJ.g:687:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalOBJ.g:687:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalOBJ.g:688:2: iv_ruleEInt= ruleEInt EOF
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
    // InternalOBJ.g:694:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalOBJ.g:700:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalOBJ.g:701:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalOBJ.g:701:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalOBJ.g:702:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalOBJ.g:702:3: (kw= '-' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalOBJ.g:703:4: kw= '-'
                    {
                    kw=(Token)match(input,23,FOLLOW_19); 

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
    // InternalOBJ.g:720:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalOBJ.g:720:47: (iv_ruleEString= ruleEString EOF )
            // InternalOBJ.g:721:2: iv_ruleEString= ruleEString EOF
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
    // InternalOBJ.g:727:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' )+ ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalOBJ.g:733:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' )+ )
            // InternalOBJ.g:734:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' )+
            {
            // InternalOBJ.g:734:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=7;
                switch ( input.LA(1) ) {
                case RULE_STRING:
                    {
                    alt16=1;
                    }
                    break;
                case RULE_ID:
                    {
                    alt16=2;
                    }
                    break;
                case 24:
                    {
                    alt16=3;
                    }
                    break;
                case 22:
                    {
                    alt16=4;
                    }
                    break;
                case 25:
                    {
                    alt16=5;
                    }
                    break;
                case 26:
                    {
                    alt16=6;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // InternalOBJ.g:735:3: this_STRING_0= RULE_STRING
            	    {
            	    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            	    			current.merge(this_STRING_0);
            	    		

            	    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalOBJ.g:743:3: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_20); 

            	    			current.merge(this_ID_1);
            	    		

            	    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalOBJ.g:751:3: kw= '.'
            	    {
            	    kw=(Token)match(input,24,FOLLOW_20); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getFullStopKeyword_2());
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalOBJ.g:757:3: kw= '/'
            	    {
            	    kw=(Token)match(input,22,FOLLOW_20); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getSolidusKeyword_3());
            	    		

            	    }
            	    break;
            	case 5 :
            	    // InternalOBJ.g:763:3: kw= '\\\\'
            	    {
            	    kw=(Token)match(input,25,FOLLOW_20); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getReverseSolidusKeyword_4());
            	    		

            	    }
            	    break;
            	case 6 :
            	    // InternalOBJ.g:769:3: kw= ':'
            	    {
            	    kw=(Token)match(input,26,FOLLOW_20); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getColonKeyword_5());
            	    		

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
    // InternalOBJ.g:778:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalOBJ.g:778:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalOBJ.g:779:2: iv_ruleEDouble= ruleEDouble EOF
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
    // InternalOBJ.g:785:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_0=null;
        AntlrDatatypeRuleToken this_EInt_1 = null;



        	enterRule();

        try {
            // InternalOBJ.g:791:2: ( (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt ) )
            // InternalOBJ.g:792:2: (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt )
            {
            // InternalOBJ.g:792:2: (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_DOUBLE) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_INT||LA17_0==23) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalOBJ.g:793:3: this_DOUBLE_0= RULE_DOUBLE
                    {
                    this_DOUBLE_0=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

                    			current.merge(this_DOUBLE_0);
                    		

                    			newLeafNode(this_DOUBLE_0, grammarAccess.getEDoubleAccess().getDOUBLETerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOBJ.g:801:3: this_EInt_1= ruleEInt
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
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\3\11\uffff";
    static final String dfa_3s = "\1\4\1\uffff\1\4\1\uffff\6\4";
    static final String dfa_4s = "\1\24\1\uffff\1\32\1\uffff\6\32";
    static final String dfa_5s = "\1\uffff\1\1\1\uffff\1\2\6\uffff";
    static final String dfa_6s = "\12\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\11\uffff\1\1\1\2\2\1\3\3",
            "",
            "\1\1\1\uffff\1\4\1\5\10\uffff\2\1\4\uffff\1\7\1\uffff\1\6\1\10\1\11",
            "",
            "\1\1\1\uffff\1\4\1\5\10\uffff\2\1\3\3\1\uffff\1\7\1\uffff\1\6\1\10\1\11",
            "\1\1\1\uffff\1\4\1\5\10\uffff\2\1\3\3\1\uffff\1\7\1\uffff\1\6\1\10\1\11",
            "\1\1\1\uffff\1\4\1\5\10\uffff\2\1\3\3\1\uffff\1\7\1\uffff\1\6\1\10\1\11",
            "\1\1\1\uffff\1\4\1\5\10\uffff\2\1\3\3\1\uffff\1\7\1\uffff\1\6\1\10\1\11",
            "\1\1\1\uffff\1\4\1\5\10\uffff\2\1\3\3\1\uffff\1\7\1\uffff\1\6\1\10\1\11",
            "\1\1\1\uffff\1\4\1\5\10\uffff\2\1\3\3\1\uffff\1\7\1\uffff\1\6\1\10\1\11"
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
            return "79:3: ( (lv_vertexSource_0_0= ruleVertexSource ) )?";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000001C8002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000074000C0L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000003C010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000074300D0L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000030010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000800120L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000030012L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000001C0000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000980120L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000A00120L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000C00122L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000C00120L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800122L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000000074000C2L});

}