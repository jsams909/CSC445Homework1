package org.example;

import java.io.IOException;
import java.io.PushbackReader;
import java.util.ArrayList;
import java.util.List;

public class Scanner {

    enum TOKEN {
        SCANEOF, ID, INTLITERAL, VAR, WRITE, INIT, EQUALS,
        NOTEQUALS, IF, THEN, ENDIF, WHILE, DO,
        ENDWHILE, CALCULATE, PLUS;
    }

    PushbackReader pbr;

    List<String> reservedWords;



    public Scanner(PushbackReader pbr) {
        this.pbr = pbr;
        reservedWords = new ArrayList<String>();
        reservedWords.add("var");
        reservedWords.add("write");
        reservedWords.add("init");
        reservedWords.add("if");
        reservedWords.add("then");
        reservedWords.add("endif");
        reservedWords.add("calculate");
        reservedWords.add("do");
        reservedWords.add("while");
        reservedWords.add("endwhile");

    }

    StringBuilder tokenBuffer = new StringBuilder();

    TOKEN scan() throws IOException {
        tokenBuffer.setLength(0);
        int c;
        c = pbr.read();

        while (c != -1 && c!=65535) {

            if (c == 32 || c == 9 || c == 10 || c == 13) {
                tokenBuffer.setLength(0);
                c = pbr.read();
                continue;
            }
            tokenBuffer.append((char) c);


            if (Character.isLetter((char) c)) {
                c = pbr.read();
                while (Character.isLetterOrDigit((char) c)) {
                    tokenBuffer.append((char) c);
                    c = pbr.read();
                }

                pbr.unread(c);
                if (reservedWords.contains(tokenBuffer.toString())) {

                    return TOKEN.valueOf(tokenBuffer.toString().toUpperCase());



                }
                else {

                    return TOKEN.ID;
                }

            } else if (c == '!') {

                c = pbr.read();
                if (c == '=') {

                    return TOKEN.NOTEQUALS;
                }
            } else if (c == '+') {

                return TOKEN.PLUS;
            } else if (c == '=') {

                return TOKEN.EQUALS;
            } else if (Character.isDigit((char) c)) {
                c = pbr.read();

                while (Character.isDigit((char) c) && c!=-1) {
                    tokenBuffer.append((char) c);
                    c = pbr.read();

                }
                pbr.unread(c);
                return TOKEN.INTLITERAL;
            }
            else{
                c = pbr.read();

            }

        }
        return TOKEN.SCANEOF;
    }

    String getTokenBufferString() {
        return tokenBuffer.toString();

    }

}



