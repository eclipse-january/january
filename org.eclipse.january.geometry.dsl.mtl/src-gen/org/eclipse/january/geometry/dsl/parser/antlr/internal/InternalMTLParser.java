package org.eclipse.january.geometry.dsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.january.geometry.dsl.services.MTLGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMTLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_DOUBLE", "RULE_SL_COMMENT", "RULE_WS", "RULE_ML_COMMENT", "RULE_ANY_OTHER", "'newmtl'", "'Ka'", "'Kd'", "'Ks'", "'Ns'", "'d'", "'Tr'", "'illum'", "'map_Ka'", "'map_Kd'", "'map_Ks'", "'map_Ns'", "'map_d'", "'map_bump'", "'-'", "'.'", "'/'", "'\\\\'", "':'", "'_'"
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
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_ID=6;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMTLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMTLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMTLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMTL.g"; }



     	private MTLGrammarAccess grammarAccess;

        public InternalMTLParser(TokenStream input, MTLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "MaterialSource";
       	}

       	@Override
       	protected MTLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleMaterialSource"
    // InternalMTL.g:64:1: entryRuleMaterialSource returns [EObject current=null] : iv_ruleMaterialSource= ruleMaterialSource EOF ;
    public final EObject entryRuleMaterialSource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaterialSource = null;


        try {
            // InternalMTL.g:64:55: (iv_ruleMaterialSource= ruleMaterialSource EOF )
            // InternalMTL.g:65:2: iv_ruleMaterialSource= ruleMaterialSource EOF
            {
             newCompositeNode(grammarAccess.getMaterialSourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMaterialSource=ruleMaterialSource();

            state._fsp--;

             current =iv_ruleMaterialSource; 
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
    // $ANTLR end "entryRuleMaterialSource"


    // $ANTLR start "ruleMaterialSource"
    // InternalMTL.g:71:1: ruleMaterialSource returns [EObject current=null] : ( (lv_materials_0_0= ruleMaterial ) )* ;
    public final EObject ruleMaterialSource() throws RecognitionException {
        EObject current = null;

        EObject lv_materials_0_0 = null;



        	enterRule();

        try {
            // InternalMTL.g:77:2: ( ( (lv_materials_0_0= ruleMaterial ) )* )
            // InternalMTL.g:78:2: ( (lv_materials_0_0= ruleMaterial ) )*
            {
            // InternalMTL.g:78:2: ( (lv_materials_0_0= ruleMaterial ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||(LA1_0>=14 && LA1_0<=15)||(LA1_0>=17 && LA1_0<=25)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMTL.g:79:3: (lv_materials_0_0= ruleMaterial )
            	    {
            	    // InternalMTL.g:79:3: (lv_materials_0_0= ruleMaterial )
            	    // InternalMTL.g:80:4: lv_materials_0_0= ruleMaterial
            	    {

            	    				newCompositeNode(grammarAccess.getMaterialSourceAccess().getMaterialsMaterialParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_materials_0_0=ruleMaterial();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getMaterialSourceRule());
            	    				}
            	    				add(
            	    					current,
            	    					"materials",
            	    					lv_materials_0_0,
            	    					"org.eclipse.january.geometry.xtext.MTL.Material");
            	    				afterParserOrEnumRuleCall();
            	    			

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
    // $ANTLR end "ruleMaterialSource"


    // $ANTLR start "entryRuleMaterial"
    // InternalMTL.g:100:1: entryRuleMaterial returns [EObject current=null] : iv_ruleMaterial= ruleMaterial EOF ;
    public final EObject entryRuleMaterial() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaterial = null;


        try {
            // InternalMTL.g:100:49: (iv_ruleMaterial= ruleMaterial EOF )
            // InternalMTL.g:101:2: iv_ruleMaterial= ruleMaterial EOF
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
    // InternalMTL.g:107:1: ruleMaterial returns [EObject current=null] : (this_PhongMaterial_0= rulePhongMaterial | this_TexturedMaterial_1= ruleTexturedMaterial ) ;
    public final EObject ruleMaterial() throws RecognitionException {
        EObject current = null;

        EObject this_PhongMaterial_0 = null;

        EObject this_TexturedMaterial_1 = null;



        	enterRule();

        try {
            // InternalMTL.g:113:2: ( (this_PhongMaterial_0= rulePhongMaterial | this_TexturedMaterial_1= ruleTexturedMaterial ) )
            // InternalMTL.g:114:2: (this_PhongMaterial_0= rulePhongMaterial | this_TexturedMaterial_1= ruleTexturedMaterial )
            {
            // InternalMTL.g:114:2: (this_PhongMaterial_0= rulePhongMaterial | this_TexturedMaterial_1= ruleTexturedMaterial )
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalMTL.g:115:3: this_PhongMaterial_0= rulePhongMaterial
                    {

                    			newCompositeNode(grammarAccess.getMaterialAccess().getPhongMaterialParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PhongMaterial_0=rulePhongMaterial();

                    state._fsp--;


                    			current = this_PhongMaterial_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMTL.g:124:3: this_TexturedMaterial_1= ruleTexturedMaterial
                    {

                    			newCompositeNode(grammarAccess.getMaterialAccess().getTexturedMaterialParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TexturedMaterial_1=ruleTexturedMaterial();

                    state._fsp--;


                    			current = this_TexturedMaterial_1;
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
    // $ANTLR end "ruleMaterial"


    // $ANTLR start "entryRulePhongMaterial"
    // InternalMTL.g:136:1: entryRulePhongMaterial returns [EObject current=null] : iv_rulePhongMaterial= rulePhongMaterial EOF ;
    public final EObject entryRulePhongMaterial() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhongMaterial = null;


        try {
            // InternalMTL.g:136:54: (iv_rulePhongMaterial= rulePhongMaterial EOF )
            // InternalMTL.g:137:2: iv_rulePhongMaterial= rulePhongMaterial EOF
            {
             newCompositeNode(grammarAccess.getPhongMaterialRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePhongMaterial=rulePhongMaterial();

            state._fsp--;

             current =iv_rulePhongMaterial; 
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
    // $ANTLR end "entryRulePhongMaterial"


    // $ANTLR start "rulePhongMaterial"
    // InternalMTL.g:143:1: rulePhongMaterial returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) )+ {...}?) ) ) ;
    public final EObject rulePhongMaterial() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ambient_4_0 = null;

        EObject lv_diffuse_6_0 = null;

        EObject lv_specular_8_0 = null;

        AntlrDatatypeRuleToken lv_specularExponent_10_0 = null;

        AntlrDatatypeRuleToken lv_opaque_12_0 = null;

        AntlrDatatypeRuleToken lv_transparent_14_0 = null;

        AntlrDatatypeRuleToken lv_illumination_16_0 = null;



        	enterRule();

        try {
            // InternalMTL.g:149:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) )+ {...}?) ) ) )
            // InternalMTL.g:150:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) )+ {...}?) ) )
            {
            // InternalMTL.g:150:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) )+ {...}?) ) )
            // InternalMTL.g:151:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalMTL.g:151:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) )+ {...}?) )
            // InternalMTL.g:152:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getPhongMaterialAccess().getUnorderedGroup());
            			
            // InternalMTL.g:155:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) )+ {...}?)
            // InternalMTL.g:156:5: ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) )+ {...}?
            {
            // InternalMTL.g:156:5: ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=6;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // InternalMTL.g:157:3: ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) )
            	    {
            	    // InternalMTL.g:157:3: ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) )
            	    // InternalMTL.g:158:4: {...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "rulePhongMaterial", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalMTL.g:158:107: ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) )
            	    // InternalMTL.g:159:5: ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalMTL.g:162:8: ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) )
            	    // InternalMTL.g:162:9: {...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhongMaterial", "true");
            	    }
            	    // InternalMTL.g:162:18: (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) )
            	    // InternalMTL.g:162:19: otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) )
            	    {
            	    otherlv_1=(Token)match(input,12,FOLLOW_4); 

            	    								newLeafNode(otherlv_1, grammarAccess.getPhongMaterialAccess().getNewmtlKeyword_0_0());
            	    							
            	    // InternalMTL.g:166:8: ( (lv_name_2_0= ruleEString ) )
            	    // InternalMTL.g:167:9: (lv_name_2_0= ruleEString )
            	    {
            	    // InternalMTL.g:167:9: (lv_name_2_0= ruleEString )
            	    // InternalMTL.g:168:10: lv_name_2_0= ruleEString
            	    {

            	    										newCompositeNode(grammarAccess.getPhongMaterialAccess().getNameEStringParserRuleCall_0_1_0());
            	    									
            	    pushFollow(FOLLOW_5);
            	    lv_name_2_0=ruleEString();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getPhongMaterialRule());
            	    										}
            	    										set(
            	    											current,
            	    											"name",
            	    											lv_name_2_0,
            	    											"org.eclipse.january.geometry.xtext.MTL.EString");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    // InternalMTL.g:185:8: (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) )
            	    // InternalMTL.g:186:9: otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FOLLOW_6); 

            	    									newLeafNode(otherlv_3, grammarAccess.getPhongMaterialAccess().getKaKeyword_0_2_0());
            	    								
            	    // InternalMTL.g:190:9: ( (lv_ambient_4_0= ruleColor ) )
            	    // InternalMTL.g:191:10: (lv_ambient_4_0= ruleColor )
            	    {
            	    // InternalMTL.g:191:10: (lv_ambient_4_0= ruleColor )
            	    // InternalMTL.g:192:11: lv_ambient_4_0= ruleColor
            	    {

            	    											newCompositeNode(grammarAccess.getPhongMaterialAccess().getAmbientColorParserRuleCall_0_2_1_0());
            	    										
            	    pushFollow(FOLLOW_7);
            	    lv_ambient_4_0=ruleColor();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getPhongMaterialRule());
            	    											}
            	    											set(
            	    												current,
            	    												"ambient",
            	    												lv_ambient_4_0,
            	    												"org.eclipse.january.geometry.xtext.MTL.Color");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPhongMaterialAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMTL.g:216:3: ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) )
            	    {
            	    // InternalMTL.g:216:3: ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) )
            	    // InternalMTL.g:217:4: {...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "rulePhongMaterial", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalMTL.g:217:107: ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) )
            	    // InternalMTL.g:218:5: ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalMTL.g:221:8: ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) )
            	    // InternalMTL.g:221:9: {...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhongMaterial", "true");
            	    }
            	    // InternalMTL.g:221:18: (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) )
            	    // InternalMTL.g:221:19: otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_6); 

            	    								newLeafNode(otherlv_5, grammarAccess.getPhongMaterialAccess().getKdKeyword_1_0());
            	    							
            	    // InternalMTL.g:225:8: ( (lv_diffuse_6_0= ruleColor ) )
            	    // InternalMTL.g:226:9: (lv_diffuse_6_0= ruleColor )
            	    {
            	    // InternalMTL.g:226:9: (lv_diffuse_6_0= ruleColor )
            	    // InternalMTL.g:227:10: lv_diffuse_6_0= ruleColor
            	    {

            	    										newCompositeNode(grammarAccess.getPhongMaterialAccess().getDiffuseColorParserRuleCall_1_1_0());
            	    									
            	    pushFollow(FOLLOW_7);
            	    lv_diffuse_6_0=ruleColor();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getPhongMaterialRule());
            	    										}
            	    										set(
            	    											current,
            	    											"diffuse",
            	    											lv_diffuse_6_0,
            	    											"org.eclipse.january.geometry.xtext.MTL.Color");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPhongMaterialAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalMTL.g:250:3: ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) )
            	    {
            	    // InternalMTL.g:250:3: ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) )
            	    // InternalMTL.g:251:4: {...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "rulePhongMaterial", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 2)");
            	    }
            	    // InternalMTL.g:251:107: ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) )
            	    // InternalMTL.g:252:5: ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 2);
            	    				
            	    // InternalMTL.g:255:8: ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) )
            	    // InternalMTL.g:255:9: {...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhongMaterial", "true");
            	    }
            	    // InternalMTL.g:255:18: (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? )
            	    // InternalMTL.g:255:19: otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )?
            	    {
            	    otherlv_7=(Token)match(input,15,FOLLOW_6); 

            	    								newLeafNode(otherlv_7, grammarAccess.getPhongMaterialAccess().getKsKeyword_2_0());
            	    							
            	    // InternalMTL.g:259:8: ( (lv_specular_8_0= ruleColor ) )
            	    // InternalMTL.g:260:9: (lv_specular_8_0= ruleColor )
            	    {
            	    // InternalMTL.g:260:9: (lv_specular_8_0= ruleColor )
            	    // InternalMTL.g:261:10: lv_specular_8_0= ruleColor
            	    {

            	    										newCompositeNode(grammarAccess.getPhongMaterialAccess().getSpecularColorParserRuleCall_2_1_0());
            	    									
            	    pushFollow(FOLLOW_8);
            	    lv_specular_8_0=ruleColor();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getPhongMaterialRule());
            	    										}
            	    										set(
            	    											current,
            	    											"specular",
            	    											lv_specular_8_0,
            	    											"org.eclipse.january.geometry.xtext.MTL.Color");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    // InternalMTL.g:278:8: (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )?
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==16) ) {
            	        alt3=1;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // InternalMTL.g:279:9: otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) )
            	            {
            	            otherlv_9=(Token)match(input,16,FOLLOW_6); 

            	            									newLeafNode(otherlv_9, grammarAccess.getPhongMaterialAccess().getNsKeyword_2_2_0());
            	            								
            	            // InternalMTL.g:283:9: ( (lv_specularExponent_10_0= ruleEDouble ) )
            	            // InternalMTL.g:284:10: (lv_specularExponent_10_0= ruleEDouble )
            	            {
            	            // InternalMTL.g:284:10: (lv_specularExponent_10_0= ruleEDouble )
            	            // InternalMTL.g:285:11: lv_specularExponent_10_0= ruleEDouble
            	            {

            	            											newCompositeNode(grammarAccess.getPhongMaterialAccess().getSpecularExponentEDoubleParserRuleCall_2_2_1_0());
            	            										
            	            pushFollow(FOLLOW_7);
            	            lv_specularExponent_10_0=ruleEDouble();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getPhongMaterialRule());
            	            											}
            	            											set(
            	            												current,
            	            												"specularExponent",
            	            												lv_specularExponent_10_0,
            	            												"org.eclipse.january.geometry.xtext.MTL.EDouble");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPhongMaterialAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalMTL.g:309:3: ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) )
            	    {
            	    // InternalMTL.g:309:3: ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) )
            	    // InternalMTL.g:310:4: {...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "rulePhongMaterial", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3)");
            	    }
            	    // InternalMTL.g:310:107: ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) )
            	    // InternalMTL.g:311:5: ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3);
            	    				
            	    // InternalMTL.g:314:8: ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) )
            	    // InternalMTL.g:314:9: {...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhongMaterial", "true");
            	    }
            	    // InternalMTL.g:314:18: ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==17) ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0==18) ) {
            	        alt4=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // InternalMTL.g:314:19: (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) )
            	            {
            	            // InternalMTL.g:314:19: (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) )
            	            // InternalMTL.g:315:9: otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) )
            	            {
            	            otherlv_11=(Token)match(input,17,FOLLOW_6); 

            	            									newLeafNode(otherlv_11, grammarAccess.getPhongMaterialAccess().getDKeyword_3_0_0());
            	            								
            	            // InternalMTL.g:319:9: ( (lv_opaque_12_0= ruleEDouble ) )
            	            // InternalMTL.g:320:10: (lv_opaque_12_0= ruleEDouble )
            	            {
            	            // InternalMTL.g:320:10: (lv_opaque_12_0= ruleEDouble )
            	            // InternalMTL.g:321:11: lv_opaque_12_0= ruleEDouble
            	            {

            	            											newCompositeNode(grammarAccess.getPhongMaterialAccess().getOpaqueEDoubleParserRuleCall_3_0_1_0());
            	            										
            	            pushFollow(FOLLOW_7);
            	            lv_opaque_12_0=ruleEDouble();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getPhongMaterialRule());
            	            											}
            	            											set(
            	            												current,
            	            												"opaque",
            	            												lv_opaque_12_0,
            	            												"org.eclipse.january.geometry.xtext.MTL.EDouble");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalMTL.g:340:8: (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) )
            	            {
            	            // InternalMTL.g:340:8: (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) )
            	            // InternalMTL.g:341:9: otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) )
            	            {
            	            otherlv_13=(Token)match(input,18,FOLLOW_6); 

            	            									newLeafNode(otherlv_13, grammarAccess.getPhongMaterialAccess().getTrKeyword_3_1_0());
            	            								
            	            // InternalMTL.g:345:9: ( (lv_transparent_14_0= ruleEDouble ) )
            	            // InternalMTL.g:346:10: (lv_transparent_14_0= ruleEDouble )
            	            {
            	            // InternalMTL.g:346:10: (lv_transparent_14_0= ruleEDouble )
            	            // InternalMTL.g:347:11: lv_transparent_14_0= ruleEDouble
            	            {

            	            											newCompositeNode(grammarAccess.getPhongMaterialAccess().getTransparentEDoubleParserRuleCall_3_1_1_0());
            	            										
            	            pushFollow(FOLLOW_7);
            	            lv_transparent_14_0=ruleEDouble();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getPhongMaterialRule());
            	            											}
            	            											set(
            	            												current,
            	            												"transparent",
            	            												lv_transparent_14_0,
            	            												"org.eclipse.january.geometry.xtext.MTL.EDouble");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPhongMaterialAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalMTL.g:371:3: ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) )
            	    {
            	    // InternalMTL.g:371:3: ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) )
            	    // InternalMTL.g:372:4: {...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 4) ) {
            	        throw new FailedPredicateException(input, "rulePhongMaterial", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 4)");
            	    }
            	    // InternalMTL.g:372:107: ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) )
            	    // InternalMTL.g:373:5: ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 4);
            	    				
            	    // InternalMTL.g:376:8: ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) )
            	    // InternalMTL.g:376:9: {...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhongMaterial", "true");
            	    }
            	    // InternalMTL.g:376:18: (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) )
            	    // InternalMTL.g:376:19: otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) )
            	    {
            	    otherlv_15=(Token)match(input,19,FOLLOW_6); 

            	    								newLeafNode(otherlv_15, grammarAccess.getPhongMaterialAccess().getIllumKeyword_4_0());
            	    							
            	    // InternalMTL.g:380:8: ( (lv_illumination_16_0= ruleEInt ) )
            	    // InternalMTL.g:381:9: (lv_illumination_16_0= ruleEInt )
            	    {
            	    // InternalMTL.g:381:9: (lv_illumination_16_0= ruleEInt )
            	    // InternalMTL.g:382:10: lv_illumination_16_0= ruleEInt
            	    {

            	    										newCompositeNode(grammarAccess.getPhongMaterialAccess().getIlluminationEIntParserRuleCall_4_1_0());
            	    									
            	    pushFollow(FOLLOW_7);
            	    lv_illumination_16_0=ruleEInt();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getPhongMaterialRule());
            	    										}
            	    										set(
            	    											current,
            	    											"illumination",
            	    											lv_illumination_16_0,
            	    											"org.eclipse.january.geometry.xtext.MTL.EInt");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPhongMaterialAccess().getUnorderedGroup());
            	    				

            	    }


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

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "rulePhongMaterial", "getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup());
            			

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
    // $ANTLR end "rulePhongMaterial"


    // $ANTLR start "entryRuleTexturedMaterial"
    // InternalMTL.g:416:1: entryRuleTexturedMaterial returns [EObject current=null] : iv_ruleTexturedMaterial= ruleTexturedMaterial EOF ;
    public final EObject entryRuleTexturedMaterial() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTexturedMaterial = null;


        try {
            // InternalMTL.g:416:57: (iv_ruleTexturedMaterial= ruleTexturedMaterial EOF )
            // InternalMTL.g:417:2: iv_ruleTexturedMaterial= ruleTexturedMaterial EOF
            {
             newCompositeNode(grammarAccess.getTexturedMaterialRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTexturedMaterial=ruleTexturedMaterial();

            state._fsp--;

             current =iv_ruleTexturedMaterial; 
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
    // $ANTLR end "entryRuleTexturedMaterial"


    // $ANTLR start "ruleTexturedMaterial"
    // InternalMTL.g:423:1: ruleTexturedMaterial returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleTexturedMaterial() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ambient_4_0 = null;

        EObject lv_diffuse_6_0 = null;

        EObject lv_specular_8_0 = null;

        AntlrDatatypeRuleToken lv_specularExponent_10_0 = null;

        AntlrDatatypeRuleToken lv_opaque_12_0 = null;

        AntlrDatatypeRuleToken lv_transparent_14_0 = null;

        AntlrDatatypeRuleToken lv_illumination_16_0 = null;

        AntlrDatatypeRuleToken lv_ambientMap_18_0 = null;

        AntlrDatatypeRuleToken lv_diffuseMap_20_0 = null;

        AntlrDatatypeRuleToken lv_specularMap_22_0 = null;

        AntlrDatatypeRuleToken lv_specularHighlightMap_24_0 = null;

        AntlrDatatypeRuleToken lv_alphaMap_26_0 = null;

        AntlrDatatypeRuleToken lv_bumpMap_28_0 = null;



        	enterRule();

        try {
            // InternalMTL.g:429:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) )
            // InternalMTL.g:430:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) )
            {
            // InternalMTL.g:430:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) )
            // InternalMTL.g:431:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalMTL.g:431:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) ) ) ) )+ {...}?) )
            // InternalMTL.g:432:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup());
            			
            // InternalMTL.g:435:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) ) ) ) )+ {...}?)
            // InternalMTL.g:436:5: ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) ) ) ) )+ {...}?
            {
            // InternalMTL.g:436:5: ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) ) ) ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=12;
                alt8 = dfa8.predict(input);
                switch (alt8) {
            	case 1 :
            	    // InternalMTL.g:437:3: ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) )
            	    {
            	    // InternalMTL.g:437:3: ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) )
            	    // InternalMTL.g:438:4: {...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalMTL.g:438:110: ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) )
            	    // InternalMTL.g:439:5: ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalMTL.g:442:8: ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) )
            	    // InternalMTL.g:442:9: {...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "true");
            	    }
            	    // InternalMTL.g:442:18: (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) )
            	    // InternalMTL.g:442:19: otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) )
            	    {
            	    otherlv_1=(Token)match(input,12,FOLLOW_4); 

            	    								newLeafNode(otherlv_1, grammarAccess.getTexturedMaterialAccess().getNewmtlKeyword_0_0());
            	    							
            	    // InternalMTL.g:446:8: ( (lv_name_2_0= ruleEString ) )
            	    // InternalMTL.g:447:9: (lv_name_2_0= ruleEString )
            	    {
            	    // InternalMTL.g:447:9: (lv_name_2_0= ruleEString )
            	    // InternalMTL.g:448:10: lv_name_2_0= ruleEString
            	    {

            	    										newCompositeNode(grammarAccess.getTexturedMaterialAccess().getNameEStringParserRuleCall_0_1_0());
            	    									
            	    pushFollow(FOLLOW_5);
            	    lv_name_2_0=ruleEString();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getTexturedMaterialRule());
            	    										}
            	    										set(
            	    											current,
            	    											"name",
            	    											lv_name_2_0,
            	    											"org.eclipse.january.geometry.xtext.MTL.EString");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    // InternalMTL.g:465:8: (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) )
            	    // InternalMTL.g:466:9: otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FOLLOW_6); 

            	    									newLeafNode(otherlv_3, grammarAccess.getTexturedMaterialAccess().getKaKeyword_0_2_0());
            	    								
            	    // InternalMTL.g:470:9: ( (lv_ambient_4_0= ruleColor ) )
            	    // InternalMTL.g:471:10: (lv_ambient_4_0= ruleColor )
            	    {
            	    // InternalMTL.g:471:10: (lv_ambient_4_0= ruleColor )
            	    // InternalMTL.g:472:11: lv_ambient_4_0= ruleColor
            	    {

            	    											newCompositeNode(grammarAccess.getTexturedMaterialAccess().getAmbientColorParserRuleCall_0_2_1_0());
            	    										
            	    pushFollow(FOLLOW_3);
            	    lv_ambient_4_0=ruleColor();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getTexturedMaterialRule());
            	    											}
            	    											set(
            	    												current,
            	    												"ambient",
            	    												lv_ambient_4_0,
            	    												"org.eclipse.january.geometry.xtext.MTL.Color");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMTL.g:496:3: ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) )
            	    {
            	    // InternalMTL.g:496:3: ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) )
            	    // InternalMTL.g:497:4: {...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalMTL.g:497:110: ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) )
            	    // InternalMTL.g:498:5: ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalMTL.g:501:8: ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) )
            	    // InternalMTL.g:501:9: {...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "true");
            	    }
            	    // InternalMTL.g:501:18: (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) )
            	    // InternalMTL.g:501:19: otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_6); 

            	    								newLeafNode(otherlv_5, grammarAccess.getTexturedMaterialAccess().getKdKeyword_1_0());
            	    							
            	    // InternalMTL.g:505:8: ( (lv_diffuse_6_0= ruleColor ) )
            	    // InternalMTL.g:506:9: (lv_diffuse_6_0= ruleColor )
            	    {
            	    // InternalMTL.g:506:9: (lv_diffuse_6_0= ruleColor )
            	    // InternalMTL.g:507:10: lv_diffuse_6_0= ruleColor
            	    {

            	    										newCompositeNode(grammarAccess.getTexturedMaterialAccess().getDiffuseColorParserRuleCall_1_1_0());
            	    									
            	    pushFollow(FOLLOW_3);
            	    lv_diffuse_6_0=ruleColor();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getTexturedMaterialRule());
            	    										}
            	    										set(
            	    											current,
            	    											"diffuse",
            	    											lv_diffuse_6_0,
            	    											"org.eclipse.january.geometry.xtext.MTL.Color");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalMTL.g:530:3: ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) )
            	    {
            	    // InternalMTL.g:530:3: ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) )
            	    // InternalMTL.g:531:4: {...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2)");
            	    }
            	    // InternalMTL.g:531:110: ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) )
            	    // InternalMTL.g:532:5: ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2);
            	    				
            	    // InternalMTL.g:535:8: ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) )
            	    // InternalMTL.g:535:9: {...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "true");
            	    }
            	    // InternalMTL.g:535:18: (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? )
            	    // InternalMTL.g:535:19: otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )?
            	    {
            	    otherlv_7=(Token)match(input,15,FOLLOW_6); 

            	    								newLeafNode(otherlv_7, grammarAccess.getTexturedMaterialAccess().getKsKeyword_2_0());
            	    							
            	    // InternalMTL.g:539:8: ( (lv_specular_8_0= ruleColor ) )
            	    // InternalMTL.g:540:9: (lv_specular_8_0= ruleColor )
            	    {
            	    // InternalMTL.g:540:9: (lv_specular_8_0= ruleColor )
            	    // InternalMTL.g:541:10: lv_specular_8_0= ruleColor
            	    {

            	    										newCompositeNode(grammarAccess.getTexturedMaterialAccess().getSpecularColorParserRuleCall_2_1_0());
            	    									
            	    pushFollow(FOLLOW_9);
            	    lv_specular_8_0=ruleColor();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getTexturedMaterialRule());
            	    										}
            	    										set(
            	    											current,
            	    											"specular",
            	    											lv_specular_8_0,
            	    											"org.eclipse.january.geometry.xtext.MTL.Color");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    // InternalMTL.g:558:8: (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==16) ) {
            	        alt6=1;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // InternalMTL.g:559:9: otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) )
            	            {
            	            otherlv_9=(Token)match(input,16,FOLLOW_6); 

            	            									newLeafNode(otherlv_9, grammarAccess.getTexturedMaterialAccess().getNsKeyword_2_2_0());
            	            								
            	            // InternalMTL.g:563:9: ( (lv_specularExponent_10_0= ruleEDouble ) )
            	            // InternalMTL.g:564:10: (lv_specularExponent_10_0= ruleEDouble )
            	            {
            	            // InternalMTL.g:564:10: (lv_specularExponent_10_0= ruleEDouble )
            	            // InternalMTL.g:565:11: lv_specularExponent_10_0= ruleEDouble
            	            {

            	            											newCompositeNode(grammarAccess.getTexturedMaterialAccess().getSpecularExponentEDoubleParserRuleCall_2_2_1_0());
            	            										
            	            pushFollow(FOLLOW_3);
            	            lv_specularExponent_10_0=ruleEDouble();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getTexturedMaterialRule());
            	            											}
            	            											set(
            	            												current,
            	            												"specularExponent",
            	            												lv_specularExponent_10_0,
            	            												"org.eclipse.january.geometry.xtext.MTL.EDouble");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalMTL.g:589:3: ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) )
            	    {
            	    // InternalMTL.g:589:3: ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) )
            	    // InternalMTL.g:590:4: {...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3)");
            	    }
            	    // InternalMTL.g:590:110: ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) )
            	    // InternalMTL.g:591:5: ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3);
            	    				
            	    // InternalMTL.g:594:8: ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) )
            	    // InternalMTL.g:594:9: {...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "true");
            	    }
            	    // InternalMTL.g:594:18: ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) )
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==17) ) {
            	        alt7=1;
            	    }
            	    else if ( (LA7_0==18) ) {
            	        alt7=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 7, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // InternalMTL.g:594:19: (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) )
            	            {
            	            // InternalMTL.g:594:19: (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) )
            	            // InternalMTL.g:595:9: otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) )
            	            {
            	            otherlv_11=(Token)match(input,17,FOLLOW_6); 

            	            									newLeafNode(otherlv_11, grammarAccess.getTexturedMaterialAccess().getDKeyword_3_0_0());
            	            								
            	            // InternalMTL.g:599:9: ( (lv_opaque_12_0= ruleEDouble ) )
            	            // InternalMTL.g:600:10: (lv_opaque_12_0= ruleEDouble )
            	            {
            	            // InternalMTL.g:600:10: (lv_opaque_12_0= ruleEDouble )
            	            // InternalMTL.g:601:11: lv_opaque_12_0= ruleEDouble
            	            {

            	            											newCompositeNode(grammarAccess.getTexturedMaterialAccess().getOpaqueEDoubleParserRuleCall_3_0_1_0());
            	            										
            	            pushFollow(FOLLOW_3);
            	            lv_opaque_12_0=ruleEDouble();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getTexturedMaterialRule());
            	            											}
            	            											set(
            	            												current,
            	            												"opaque",
            	            												lv_opaque_12_0,
            	            												"org.eclipse.january.geometry.xtext.MTL.EDouble");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalMTL.g:620:8: (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) )
            	            {
            	            // InternalMTL.g:620:8: (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) )
            	            // InternalMTL.g:621:9: otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) )
            	            {
            	            otherlv_13=(Token)match(input,18,FOLLOW_6); 

            	            									newLeafNode(otherlv_13, grammarAccess.getTexturedMaterialAccess().getTrKeyword_3_1_0());
            	            								
            	            // InternalMTL.g:625:9: ( (lv_transparent_14_0= ruleEDouble ) )
            	            // InternalMTL.g:626:10: (lv_transparent_14_0= ruleEDouble )
            	            {
            	            // InternalMTL.g:626:10: (lv_transparent_14_0= ruleEDouble )
            	            // InternalMTL.g:627:11: lv_transparent_14_0= ruleEDouble
            	            {

            	            											newCompositeNode(grammarAccess.getTexturedMaterialAccess().getTransparentEDoubleParserRuleCall_3_1_1_0());
            	            										
            	            pushFollow(FOLLOW_3);
            	            lv_transparent_14_0=ruleEDouble();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getTexturedMaterialRule());
            	            											}
            	            											set(
            	            												current,
            	            												"transparent",
            	            												lv_transparent_14_0,
            	            												"org.eclipse.january.geometry.xtext.MTL.EDouble");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalMTL.g:651:3: ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) )
            	    {
            	    // InternalMTL.g:651:3: ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) )
            	    // InternalMTL.g:652:4: {...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4)");
            	    }
            	    // InternalMTL.g:652:110: ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) )
            	    // InternalMTL.g:653:5: ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4);
            	    				
            	    // InternalMTL.g:656:8: ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) )
            	    // InternalMTL.g:656:9: {...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "true");
            	    }
            	    // InternalMTL.g:656:18: (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) )
            	    // InternalMTL.g:656:19: otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) )
            	    {
            	    otherlv_15=(Token)match(input,19,FOLLOW_6); 

            	    								newLeafNode(otherlv_15, grammarAccess.getTexturedMaterialAccess().getIllumKeyword_4_0());
            	    							
            	    // InternalMTL.g:660:8: ( (lv_illumination_16_0= ruleEInt ) )
            	    // InternalMTL.g:661:9: (lv_illumination_16_0= ruleEInt )
            	    {
            	    // InternalMTL.g:661:9: (lv_illumination_16_0= ruleEInt )
            	    // InternalMTL.g:662:10: lv_illumination_16_0= ruleEInt
            	    {

            	    										newCompositeNode(grammarAccess.getTexturedMaterialAccess().getIlluminationEIntParserRuleCall_4_1_0());
            	    									
            	    pushFollow(FOLLOW_3);
            	    lv_illumination_16_0=ruleEInt();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getTexturedMaterialRule());
            	    										}
            	    										set(
            	    											current,
            	    											"illumination",
            	    											lv_illumination_16_0,
            	    											"org.eclipse.january.geometry.xtext.MTL.EInt");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalMTL.g:685:3: ({...}? => ( ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) ) ) )
            	    {
            	    // InternalMTL.g:685:3: ({...}? => ( ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) ) ) )
            	    // InternalMTL.g:686:4: {...}? => ( ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5)");
            	    }
            	    // InternalMTL.g:686:110: ( ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) ) )
            	    // InternalMTL.g:687:5: ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5);
            	    				
            	    // InternalMTL.g:690:8: ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) )
            	    // InternalMTL.g:690:9: {...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "true");
            	    }
            	    // InternalMTL.g:690:18: (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) )
            	    // InternalMTL.g:690:19: otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) )
            	    {
            	    otherlv_17=(Token)match(input,20,FOLLOW_4); 

            	    								newLeafNode(otherlv_17, grammarAccess.getTexturedMaterialAccess().getMap_KaKeyword_5_0());
            	    							
            	    // InternalMTL.g:694:8: ( (lv_ambientMap_18_0= ruleEString ) )
            	    // InternalMTL.g:695:9: (lv_ambientMap_18_0= ruleEString )
            	    {
            	    // InternalMTL.g:695:9: (lv_ambientMap_18_0= ruleEString )
            	    // InternalMTL.g:696:10: lv_ambientMap_18_0= ruleEString
            	    {

            	    										newCompositeNode(grammarAccess.getTexturedMaterialAccess().getAmbientMapEStringParserRuleCall_5_1_0());
            	    									
            	    pushFollow(FOLLOW_3);
            	    lv_ambientMap_18_0=ruleEString();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getTexturedMaterialRule());
            	    										}
            	    										set(
            	    											current,
            	    											"ambientMap",
            	    											lv_ambientMap_18_0,
            	    											"org.eclipse.january.geometry.xtext.MTL.EString");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalMTL.g:719:3: ({...}? => ( ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) ) ) )
            	    {
            	    // InternalMTL.g:719:3: ({...}? => ( ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) ) ) )
            	    // InternalMTL.g:720:4: {...}? => ( ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6)");
            	    }
            	    // InternalMTL.g:720:110: ( ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) ) )
            	    // InternalMTL.g:721:5: ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6);
            	    				
            	    // InternalMTL.g:724:8: ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) )
            	    // InternalMTL.g:724:9: {...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "true");
            	    }
            	    // InternalMTL.g:724:18: (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) )
            	    // InternalMTL.g:724:19: otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) )
            	    {
            	    otherlv_19=(Token)match(input,21,FOLLOW_4); 

            	    								newLeafNode(otherlv_19, grammarAccess.getTexturedMaterialAccess().getMap_KdKeyword_6_0());
            	    							
            	    // InternalMTL.g:728:8: ( (lv_diffuseMap_20_0= ruleEString ) )
            	    // InternalMTL.g:729:9: (lv_diffuseMap_20_0= ruleEString )
            	    {
            	    // InternalMTL.g:729:9: (lv_diffuseMap_20_0= ruleEString )
            	    // InternalMTL.g:730:10: lv_diffuseMap_20_0= ruleEString
            	    {

            	    										newCompositeNode(grammarAccess.getTexturedMaterialAccess().getDiffuseMapEStringParserRuleCall_6_1_0());
            	    									
            	    pushFollow(FOLLOW_3);
            	    lv_diffuseMap_20_0=ruleEString();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getTexturedMaterialRule());
            	    										}
            	    										set(
            	    											current,
            	    											"diffuseMap",
            	    											lv_diffuseMap_20_0,
            	    											"org.eclipse.january.geometry.xtext.MTL.EString");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalMTL.g:753:3: ({...}? => ( ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) ) ) )
            	    {
            	    // InternalMTL.g:753:3: ({...}? => ( ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) ) ) )
            	    // InternalMTL.g:754:4: {...}? => ( ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7)");
            	    }
            	    // InternalMTL.g:754:110: ( ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) ) )
            	    // InternalMTL.g:755:5: ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7);
            	    				
            	    // InternalMTL.g:758:8: ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) )
            	    // InternalMTL.g:758:9: {...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "true");
            	    }
            	    // InternalMTL.g:758:18: (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) )
            	    // InternalMTL.g:758:19: otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) )
            	    {
            	    otherlv_21=(Token)match(input,22,FOLLOW_4); 

            	    								newLeafNode(otherlv_21, grammarAccess.getTexturedMaterialAccess().getMap_KsKeyword_7_0());
            	    							
            	    // InternalMTL.g:762:8: ( (lv_specularMap_22_0= ruleEString ) )
            	    // InternalMTL.g:763:9: (lv_specularMap_22_0= ruleEString )
            	    {
            	    // InternalMTL.g:763:9: (lv_specularMap_22_0= ruleEString )
            	    // InternalMTL.g:764:10: lv_specularMap_22_0= ruleEString
            	    {

            	    										newCompositeNode(grammarAccess.getTexturedMaterialAccess().getSpecularMapEStringParserRuleCall_7_1_0());
            	    									
            	    pushFollow(FOLLOW_3);
            	    lv_specularMap_22_0=ruleEString();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getTexturedMaterialRule());
            	    										}
            	    										set(
            	    											current,
            	    											"specularMap",
            	    											lv_specularMap_22_0,
            	    											"org.eclipse.january.geometry.xtext.MTL.EString");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalMTL.g:787:3: ({...}? => ( ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) ) ) )
            	    {
            	    // InternalMTL.g:787:3: ({...}? => ( ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) ) ) )
            	    // InternalMTL.g:788:4: {...}? => ( ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8)");
            	    }
            	    // InternalMTL.g:788:110: ( ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) ) )
            	    // InternalMTL.g:789:5: ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8);
            	    				
            	    // InternalMTL.g:792:8: ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) )
            	    // InternalMTL.g:792:9: {...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "true");
            	    }
            	    // InternalMTL.g:792:18: (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) )
            	    // InternalMTL.g:792:19: otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) )
            	    {
            	    otherlv_23=(Token)match(input,23,FOLLOW_4); 

            	    								newLeafNode(otherlv_23, grammarAccess.getTexturedMaterialAccess().getMap_NsKeyword_8_0());
            	    							
            	    // InternalMTL.g:796:8: ( (lv_specularHighlightMap_24_0= ruleEString ) )
            	    // InternalMTL.g:797:9: (lv_specularHighlightMap_24_0= ruleEString )
            	    {
            	    // InternalMTL.g:797:9: (lv_specularHighlightMap_24_0= ruleEString )
            	    // InternalMTL.g:798:10: lv_specularHighlightMap_24_0= ruleEString
            	    {

            	    										newCompositeNode(grammarAccess.getTexturedMaterialAccess().getSpecularHighlightMapEStringParserRuleCall_8_1_0());
            	    									
            	    pushFollow(FOLLOW_3);
            	    lv_specularHighlightMap_24_0=ruleEString();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getTexturedMaterialRule());
            	    										}
            	    										set(
            	    											current,
            	    											"specularHighlightMap",
            	    											lv_specularHighlightMap_24_0,
            	    											"org.eclipse.january.geometry.xtext.MTL.EString");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // InternalMTL.g:821:3: ({...}? => ( ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) ) ) )
            	    {
            	    // InternalMTL.g:821:3: ({...}? => ( ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) ) ) )
            	    // InternalMTL.g:822:4: {...}? => ( ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9)");
            	    }
            	    // InternalMTL.g:822:110: ( ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) ) )
            	    // InternalMTL.g:823:5: ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9);
            	    				
            	    // InternalMTL.g:826:8: ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) )
            	    // InternalMTL.g:826:9: {...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "true");
            	    }
            	    // InternalMTL.g:826:18: (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) )
            	    // InternalMTL.g:826:19: otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) )
            	    {
            	    otherlv_25=(Token)match(input,24,FOLLOW_4); 

            	    								newLeafNode(otherlv_25, grammarAccess.getTexturedMaterialAccess().getMap_dKeyword_9_0());
            	    							
            	    // InternalMTL.g:830:8: ( (lv_alphaMap_26_0= ruleEString ) )
            	    // InternalMTL.g:831:9: (lv_alphaMap_26_0= ruleEString )
            	    {
            	    // InternalMTL.g:831:9: (lv_alphaMap_26_0= ruleEString )
            	    // InternalMTL.g:832:10: lv_alphaMap_26_0= ruleEString
            	    {

            	    										newCompositeNode(grammarAccess.getTexturedMaterialAccess().getAlphaMapEStringParserRuleCall_9_1_0());
            	    									
            	    pushFollow(FOLLOW_3);
            	    lv_alphaMap_26_0=ruleEString();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getTexturedMaterialRule());
            	    										}
            	    										set(
            	    											current,
            	    											"alphaMap",
            	    											lv_alphaMap_26_0,
            	    											"org.eclipse.january.geometry.xtext.MTL.EString");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // InternalMTL.g:855:3: ({...}? => ( ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) ) ) )
            	    {
            	    // InternalMTL.g:855:3: ({...}? => ( ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) ) ) )
            	    // InternalMTL.g:856:4: {...}? => ( ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10)");
            	    }
            	    // InternalMTL.g:856:111: ( ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) ) )
            	    // InternalMTL.g:857:5: ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10);
            	    				
            	    // InternalMTL.g:860:8: ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) )
            	    // InternalMTL.g:860:9: {...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTexturedMaterial", "true");
            	    }
            	    // InternalMTL.g:860:18: (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) )
            	    // InternalMTL.g:860:19: otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) )
            	    {
            	    otherlv_27=(Token)match(input,25,FOLLOW_4); 

            	    								newLeafNode(otherlv_27, grammarAccess.getTexturedMaterialAccess().getMap_bumpKeyword_10_0());
            	    							
            	    // InternalMTL.g:864:8: ( (lv_bumpMap_28_0= ruleEString ) )
            	    // InternalMTL.g:865:9: (lv_bumpMap_28_0= ruleEString )
            	    {
            	    // InternalMTL.g:865:9: (lv_bumpMap_28_0= ruleEString )
            	    // InternalMTL.g:866:10: lv_bumpMap_28_0= ruleEString
            	    {

            	    										newCompositeNode(grammarAccess.getTexturedMaterialAccess().getBumpMapEStringParserRuleCall_10_1_0());
            	    									
            	    pushFollow(FOLLOW_3);
            	    lv_bumpMap_28_0=ruleEString();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getTexturedMaterialRule());
            	    										}
            	    										set(
            	    											current,
            	    											"bumpMap",
            	    											lv_bumpMap_28_0,
            	    											"org.eclipse.january.geometry.xtext.MTL.EString");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleTexturedMaterial", "getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup());
            			

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
    // $ANTLR end "ruleTexturedMaterial"


    // $ANTLR start "entryRuleColor"
    // InternalMTL.g:900:1: entryRuleColor returns [EObject current=null] : iv_ruleColor= ruleColor EOF ;
    public final EObject entryRuleColor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColor = null;


        try {
            // InternalMTL.g:900:46: (iv_ruleColor= ruleColor EOF )
            // InternalMTL.g:901:2: iv_ruleColor= ruleColor EOF
            {
             newCompositeNode(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColor=ruleColor();

            state._fsp--;

             current =iv_ruleColor; 
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
    // $ANTLR end "entryRuleColor"


    // $ANTLR start "ruleColor"
    // InternalMTL.g:907:1: ruleColor returns [EObject current=null] : ( ( (lv_red_0_0= ruleEDouble ) ) ( (lv_green_1_0= ruleEDouble ) ) ( (lv_blue_2_0= ruleEDouble ) ) ) ;
    public final EObject ruleColor() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_red_0_0 = null;

        AntlrDatatypeRuleToken lv_green_1_0 = null;

        AntlrDatatypeRuleToken lv_blue_2_0 = null;



        	enterRule();

        try {
            // InternalMTL.g:913:2: ( ( ( (lv_red_0_0= ruleEDouble ) ) ( (lv_green_1_0= ruleEDouble ) ) ( (lv_blue_2_0= ruleEDouble ) ) ) )
            // InternalMTL.g:914:2: ( ( (lv_red_0_0= ruleEDouble ) ) ( (lv_green_1_0= ruleEDouble ) ) ( (lv_blue_2_0= ruleEDouble ) ) )
            {
            // InternalMTL.g:914:2: ( ( (lv_red_0_0= ruleEDouble ) ) ( (lv_green_1_0= ruleEDouble ) ) ( (lv_blue_2_0= ruleEDouble ) ) )
            // InternalMTL.g:915:3: ( (lv_red_0_0= ruleEDouble ) ) ( (lv_green_1_0= ruleEDouble ) ) ( (lv_blue_2_0= ruleEDouble ) )
            {
            // InternalMTL.g:915:3: ( (lv_red_0_0= ruleEDouble ) )
            // InternalMTL.g:916:4: (lv_red_0_0= ruleEDouble )
            {
            // InternalMTL.g:916:4: (lv_red_0_0= ruleEDouble )
            // InternalMTL.g:917:5: lv_red_0_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getColorAccess().getRedEDoubleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_6);
            lv_red_0_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getColorRule());
            					}
            					set(
            						current,
            						"red",
            						lv_red_0_0,
            						"org.eclipse.january.geometry.xtext.MTL.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMTL.g:934:3: ( (lv_green_1_0= ruleEDouble ) )
            // InternalMTL.g:935:4: (lv_green_1_0= ruleEDouble )
            {
            // InternalMTL.g:935:4: (lv_green_1_0= ruleEDouble )
            // InternalMTL.g:936:5: lv_green_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getColorAccess().getGreenEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_6);
            lv_green_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getColorRule());
            					}
            					set(
            						current,
            						"green",
            						lv_green_1_0,
            						"org.eclipse.january.geometry.xtext.MTL.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMTL.g:953:3: ( (lv_blue_2_0= ruleEDouble ) )
            // InternalMTL.g:954:4: (lv_blue_2_0= ruleEDouble )
            {
            // InternalMTL.g:954:4: (lv_blue_2_0= ruleEDouble )
            // InternalMTL.g:955:5: lv_blue_2_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getColorAccess().getBlueEDoubleParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_blue_2_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getColorRule());
            					}
            					set(
            						current,
            						"blue",
            						lv_blue_2_0,
            						"org.eclipse.january.geometry.xtext.MTL.EDouble");
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
    // $ANTLR end "ruleColor"


    // $ANTLR start "entryRuleEInt"
    // InternalMTL.g:976:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalMTL.g:976:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalMTL.g:977:2: iv_ruleEInt= ruleEInt EOF
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
    // InternalMTL.g:983:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalMTL.g:989:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalMTL.g:990:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalMTL.g:990:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalMTL.g:991:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalMTL.g:991:3: (kw= '-' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==26) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalMTL.g:992:4: kw= '-'
                    {
                    kw=(Token)match(input,26,FOLLOW_10); 

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
    // InternalMTL.g:1009:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalMTL.g:1009:47: (iv_ruleEString= ruleEString EOF )
            // InternalMTL.g:1010:2: iv_ruleEString= ruleEString EOF
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
    // InternalMTL.g:1016:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_INT_2= RULE_INT | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' | kw= '_' | kw= '-' )+ ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;
        Token this_INT_2=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalMTL.g:1022:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_INT_2= RULE_INT | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' | kw= '_' | kw= '-' )+ )
            // InternalMTL.g:1023:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_INT_2= RULE_INT | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' | kw= '_' | kw= '-' )+
            {
            // InternalMTL.g:1023:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_INT_2= RULE_INT | kw= '.' | kw= '/' | kw= '\\\\' | kw= ':' | kw= '_' | kw= '-' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=10;
                switch ( input.LA(1) ) {
                case RULE_STRING:
                    {
                    alt10=1;
                    }
                    break;
                case RULE_ID:
                    {
                    alt10=2;
                    }
                    break;
                case RULE_INT:
                    {
                    alt10=3;
                    }
                    break;
                case 27:
                    {
                    alt10=4;
                    }
                    break;
                case 28:
                    {
                    alt10=5;
                    }
                    break;
                case 29:
                    {
                    alt10=6;
                    }
                    break;
                case 30:
                    {
                    alt10=7;
                    }
                    break;
                case 31:
                    {
                    alt10=8;
                    }
                    break;
                case 26:
                    {
                    alt10=9;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // InternalMTL.g:1024:3: this_STRING_0= RULE_STRING
            	    {
            	    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_11); 

            	    			current.merge(this_STRING_0);
            	    		

            	    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalMTL.g:1032:3: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_11); 

            	    			current.merge(this_ID_1);
            	    		

            	    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalMTL.g:1040:3: this_INT_2= RULE_INT
            	    {
            	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_11); 

            	    			current.merge(this_INT_2);
            	    		

            	    			newLeafNode(this_INT_2, grammarAccess.getEStringAccess().getINTTerminalRuleCall_2());
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalMTL.g:1048:3: kw= '.'
            	    {
            	    kw=(Token)match(input,27,FOLLOW_11); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getFullStopKeyword_3());
            	    		

            	    }
            	    break;
            	case 5 :
            	    // InternalMTL.g:1054:3: kw= '/'
            	    {
            	    kw=(Token)match(input,28,FOLLOW_11); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getSolidusKeyword_4());
            	    		

            	    }
            	    break;
            	case 6 :
            	    // InternalMTL.g:1060:3: kw= '\\\\'
            	    {
            	    kw=(Token)match(input,29,FOLLOW_11); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getReverseSolidusKeyword_5());
            	    		

            	    }
            	    break;
            	case 7 :
            	    // InternalMTL.g:1066:3: kw= ':'
            	    {
            	    kw=(Token)match(input,30,FOLLOW_11); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getColonKeyword_6());
            	    		

            	    }
            	    break;
            	case 8 :
            	    // InternalMTL.g:1072:3: kw= '_'
            	    {
            	    kw=(Token)match(input,31,FOLLOW_11); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().get_Keyword_7());
            	    		

            	    }
            	    break;
            	case 9 :
            	    // InternalMTL.g:1078:3: kw= '-'
            	    {
            	    kw=(Token)match(input,26,FOLLOW_11); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getEStringAccess().getHyphenMinusKeyword_8());
            	    		

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
    // InternalMTL.g:1087:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalMTL.g:1087:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalMTL.g:1088:2: iv_ruleEDouble= ruleEDouble EOF
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
    // InternalMTL.g:1094:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_0=null;
        AntlrDatatypeRuleToken this_EInt_1 = null;



        	enterRule();

        try {
            // InternalMTL.g:1100:2: ( (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt ) )
            // InternalMTL.g:1101:2: (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt )
            {
            // InternalMTL.g:1101:2: (this_DOUBLE_0= RULE_DOUBLE | this_EInt_1= ruleEInt )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_DOUBLE) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_INT||LA11_0==26) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalMTL.g:1102:3: this_DOUBLE_0= RULE_DOUBLE
                    {
                    this_DOUBLE_0=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

                    			current.merge(this_DOUBLE_0);
                    		

                    			newLeafNode(this_DOUBLE_0, grammarAccess.getEDoubleAccess().getDOUBLETerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMTL.g:1110:3: this_EInt_1= ruleEInt
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


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA8 dfa8 = new DFA8(this);
    static final String dfa_1s = "\65\uffff";
    static final String dfa_2s = "\1\14\6\4\1\uffff\17\4\1\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\12\4\1\uffff\1\4\2\uffff\1\4\1\uffff\3\4\1\uffff\1\4\1\uffff";
    static final String dfa_3s = "\1\31\1\37\5\32\1\uffff\11\37\1\32\1\4\2\32\1\4\1\32\1\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\2\32\1\4\2\32\1\4\2\32\1\4\1\32\1\uffff\1\4\2\uffff\1\4\1\uffff\1\32\1\4\1\32\1\uffff\1\4\1\uffff";
    static final String dfa_4s = "\7\uffff\1\2\17\uffff\1\1\1\uffff\2\1\1\uffff\1\1\1\uffff\1\1\12\uffff\1\1\1\uffff\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\1";
    static final String dfa_5s = "\65\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\uffff\1\2\1\3\1\uffff\1\4\1\5\1\6\6\7",
            "\1\12\1\10\1\11\23\uffff\1\20\1\13\1\14\1\15\1\16\1\17",
            "\1\23\2\uffff\1\21\22\uffff\1\22",
            "\1\26\2\uffff\1\24\22\uffff\1\25",
            "\1\31\2\uffff\1\27\22\uffff\1\30",
            "\1\34\2\uffff\1\32\22\uffff\1\33",
            "\1\36\25\uffff\1\35",
            "",
            "\1\12\1\10\1\11\6\uffff\1\37\14\uffff\1\20\1\13\1\14\1\15\1\16\1\17",
            "\1\12\1\10\1\11\6\uffff\1\37\14\uffff\1\20\1\13\1\14\1\15\1\16\1\17",
            "\1\12\1\10\1\11\6\uffff\1\37\14\uffff\1\20\1\13\1\14\1\15\1\16\1\17",
            "\1\12\1\10\1\11\6\uffff\1\37\14\uffff\1\20\1\13\1\14\1\15\1\16\1\17",
            "\1\12\1\10\1\11\6\uffff\1\37\14\uffff\1\20\1\13\1\14\1\15\1\16\1\17",
            "\1\12\1\10\1\11\6\uffff\1\37\14\uffff\1\20\1\13\1\14\1\15\1\16\1\17",
            "\1\12\1\10\1\11\6\uffff\1\37\14\uffff\1\20\1\13\1\14\1\15\1\16\1\17",
            "\1\12\1\10\1\11\6\uffff\1\37\14\uffff\1\20\1\13\1\14\1\15\1\16\1\17",
            "\1\12\1\10\1\11\6\uffff\1\37\14\uffff\1\20\1\13\1\14\1\15\1\16\1\17",
            "\1\42\2\uffff\1\40\22\uffff\1\41",
            "\1\23",
            "\1\42\2\uffff\1\40\22\uffff\1\41",
            "\1\45\2\uffff\1\43\22\uffff\1\44",
            "\1\26",
            "\1\45\2\uffff\1\43\22\uffff\1\44",
            "",
            "\1\31",
            "",
            "",
            "\1\34",
            "",
            "\1\36",
            "",
            "\1\50\2\uffff\1\46\22\uffff\1\47",
            "\1\53\2\uffff\1\51\22\uffff\1\52",
            "\1\42",
            "\1\53\2\uffff\1\51\22\uffff\1\52",
            "\1\56\2\uffff\1\54\22\uffff\1\55",
            "\1\45",
            "\1\56\2\uffff\1\54\22\uffff\1\55",
            "\1\61\2\uffff\1\57\22\uffff\1\60",
            "\1\50",
            "\1\61\2\uffff\1\57\22\uffff\1\60",
            "",
            "\1\53",
            "",
            "",
            "\1\56",
            "",
            "\1\64\2\uffff\1\62\22\uffff\1\63",
            "\1\61",
            "\1\64\2\uffff\1\62\22\uffff\1\63",
            "",
            "\1\64",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "114:2: (this_PhongMaterial_0= rulePhongMaterial | this_TexturedMaterial_1= ruleTexturedMaterial )";
        }
    }
    static final String dfa_7s = "\15\uffff";
    static final String dfa_8s = "\1\1\14\uffff";
    static final String dfa_9s = "\1\14\1\uffff\6\0\5\uffff";
    static final String dfa_10s = "\1\31\1\uffff\6\0\5\uffff";
    static final String dfa_11s = "\1\uffff\1\6\6\uffff\1\1\1\2\1\3\1\4\1\5";
    static final String dfa_12s = "\2\uffff\1\3\1\5\1\4\1\2\1\1\1\0\5\uffff}>";
    static final String[] dfa_13s = {
            "\1\2\1\uffff\1\3\1\4\1\uffff\1\5\1\6\1\7\6\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "()+ loopback of 156:5: ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_7 = input.LA(1);

                         
                        int index5_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 4) ) {s = 12;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index5_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_6 = input.LA(1);

                         
                        int index5_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 11;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index5_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA5_5 = input.LA(1);

                         
                        int index5_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 11;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index5_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA5_2 = input.LA(1);

                         
                        int index5_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 0) ) {s = 8;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index5_2);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA5_4 = input.LA(1);

                         
                        int index5_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 2) ) {s = 10;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index5_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA5_3 = input.LA(1);

                         
                        int index5_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 1) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index5_3);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_14s = "\31\uffff";
    static final String dfa_15s = "\1\1\30\uffff";
    static final String dfa_16s = "\1\14\1\uffff\14\0\13\uffff";
    static final String dfa_17s = "\1\31\1\uffff\14\0\13\uffff";
    static final String dfa_18s = "\1\uffff\1\14\14\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13";
    static final String dfa_19s = "\2\uffff\1\6\1\3\1\1\1\11\1\10\1\12\1\5\1\2\1\13\1\7\1\4\1\0\13\uffff}>";
    static final String[] dfa_20s = {
            "\1\2\1\uffff\1\3\1\4\1\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = dfa_14;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "()+ loopback of 436:5: ( ({...}? => ( ({...}? => (otherlv_1= 'newmtl' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'Ka' ( (lv_ambient_4_0= ruleColor ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Kd' ( (lv_diffuse_6_0= ruleColor ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'Ks' ( (lv_specular_8_0= ruleColor ) ) (otherlv_9= 'Ns' ( (lv_specularExponent_10_0= ruleEDouble ) ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_11= 'd' ( (lv_opaque_12_0= ruleEDouble ) ) ) | (otherlv_13= 'Tr' ( (lv_transparent_14_0= ruleEDouble ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'illum' ( (lv_illumination_16_0= ruleEInt ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'map_Ka' ( (lv_ambientMap_18_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'map_Kd' ( (lv_diffuseMap_20_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'map_Ks' ( (lv_specularMap_22_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'map_Ns' ( (lv_specularHighlightMap_24_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'map_d' ( (lv_alphaMap_26_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'map_bump' ( (lv_bumpMap_28_0= ruleEString ) ) ) ) ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_13 = input.LA(1);

                         
                        int index8_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 24;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index8_13);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA8_4 = input.LA(1);

                         
                        int index8_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index8_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA8_9 = input.LA(1);

                         
                        int index8_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 20;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index8_9);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA8_3 = input.LA(1);

                         
                        int index8_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 15;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index8_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA8_12 = input.LA(1);

                         
                        int index8_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 23;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index8_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA8_8 = input.LA(1);

                         
                        int index8_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 19;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index8_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA8_2 = input.LA(1);

                         
                        int index8_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 14;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index8_2);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA8_11 = input.LA(1);

                         
                        int index8_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 22;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index8_11);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA8_6 = input.LA(1);

                         
                        int index8_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 17;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index8_6);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA8_5 = input.LA(1);

                         
                        int index8_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 17;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index8_5);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA8_7 = input.LA(1);

                         
                        int index8_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4) ) {s = 18;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index8_7);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA8_10 = input.LA(1);

                         
                        int index8_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 21;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index8_10);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000003FED002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000FC000070L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000004000090L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000000ED002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000000FD002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000003FFD002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000FC000072L});

}
