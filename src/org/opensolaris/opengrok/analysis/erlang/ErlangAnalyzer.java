/*
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License (the "License").
 * You may not use this file except in compliance with the License.
 *
 * See LICENSE.txt included in this distribution for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at LICENSE.txt.
 * If applicable, add the following below this CDDL HEADER, with the
 * fields enclosed by brackets "[]" replaced with your own identifying
 * information: Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 */
package org.opensolaris.opengrok.analysis.erlang;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import org.opensolaris.opengrok.analysis.Definitions;
import org.opensolaris.opengrok.analysis.FileAnalyzerFactory;
import org.opensolaris.opengrok.analysis.JFlexTokenizer;
import org.opensolaris.opengrok.analysis.JFlexXref;
import org.opensolaris.opengrok.analysis.plain.AbstractSourceCodeAnalyzer;
import org.opensolaris.opengrok.configuration.Project;
import org.opensolaris.opengrok.history.Annotation;

public class ErlangAnalyzer extends AbstractSourceCodeAnalyzer {

    /**
     * Creates a new instance of ErlangAnalyzer
     */
    protected ErlangAnalyzer(FileAnalyzerFactory factory) {
        super(factory);
    }

//    @Override
//    protected JFlexScopeParser newScopeParser(Reader reader) {
//        return new ErlangScopeParser(reader);
//    }

    @Override
    protected JFlexTokenizer newSymbolTokenizer(Reader reader) {
        return new ErlangSymbolTokenizer(reader);
    }

    @Override
    protected JFlexXref newXref(Reader reader) {
        return new ErlangXref(reader);
    }

    static void writeXref(Reader in, Writer out, Definitions defs, Annotation annotation, Project project) throws IOException {
        ErlangXref xref = new ErlangXref(in);
        AbstractSourceCodeAnalyzer.writeXref(xref, in, out, defs, annotation, project);

    }
}
