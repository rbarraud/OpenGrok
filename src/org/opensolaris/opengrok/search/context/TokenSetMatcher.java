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

/*
 * Copyright 2005 Sun Microsystems, Inc.  All rights reserved.
 * Use is subject to license terms.
 */

/*
 * ident	"@(#)TokenSetMatcher.java 1.1     05/11/11 SMI"
 */

package org.opensolaris.opengrok.search.context;

import java.util.*;

public class TokenSetMatcher extends LineMatcher {
    private HashSet tokenSet;
    public TokenSetMatcher(HashSet tokenSet) {
        this.tokenSet  = tokenSet;
    }
    
    public int match(String token) {
        if (tokenSet.contains(token))
            return MATCHED;
        return NOT_MATCHED;
    }
}