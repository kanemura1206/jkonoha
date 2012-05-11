package sugar.tokenizer.parser;

import sugar.*;

import sugar.tokenizer.TEnv;

import commons.konoha2.CTX;
import commons.konoha2.kclass.KMethod;
import commons.konoha2.kclass.KString;

/**
 * This class is used to parse "SYMBOL" 
 * @author okachin
 *
 */

public final class ParseSYMBOL implements FTokenizer {
	
	@Override public final int parse(CTX ctx,  KToken tk, TEnv tenv, int tok_start, KMethod thunk) {
		int ch, pos = tok_start;
		String ts = tenv.source;
//		while((ch = ts.charAt(pos++)) != 0) {
		while(true) {
			pos++;
			if(pos >= ts.length()) break;
			if((ch = ts.charAt(pos)) == 0) break;
			if(ch == '_' || Character.isLetterOrDigit(ch)) continue; // nothing
			break;
		}
		if(tk != null /* CTX.IS_NOTNULL(tk) */) {
			tk.text = new KString(ts.substring(tok_start, pos)); // TODO KSETv(tk->text, new_kString(ts + tok_start, (pos-1)-tok_start, SPOL_ASCII));
			assert tk.text != null;
			tk.tt = KToken.TK_SYMBOL;
		}
		return pos;  // next
//		return pos - 1;  // next
	}
}	