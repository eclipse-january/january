package org.eclipse.january.geometry.xtext.ui;

import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

public class IGESAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		
		if ("RULE_HOLLERITH".equals(tokenName)) {
			return HighlightingStyles.STRING_ID;
		} else if ("RULE_DELIMITER".equals(tokenName)){
			return HighlightingStyles.PUNCTUATION_ID;
		} else if ("RULE_SEPARATOR".equals(tokenName)) {
			return HighlightingStyles.PUNCTUATION_ID;
		} else {
			return super.calculateId(tokenName, tokenType);
		}
		
		
	}

}
