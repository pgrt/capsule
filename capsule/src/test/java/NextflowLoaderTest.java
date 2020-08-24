/*
 * Copyright 2020, Seqera Labs
 * Copyright 2013-2019, Centre for Genomic Regulation (CRG)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
public class NextflowLoaderTest {

    @Test
    public void testExtendDeps () {
        assertEquals( NextflowLoader.extendDepsWith(null, null), null);
        assertEquals( NextflowLoader.extendDepsWith("a:a:1.0", null), Arrays.asList("a:a:1.0"));
        assertEquals( NextflowLoader.extendDepsWith("a:a:1.0 b:b:2.0", null), Arrays.asList("a:a:1.0","b:b:2.0"));
        assertEquals( NextflowLoader.extendDepsWith("a:a:1.0   b:b:2.0  ", null), Arrays.asList("a:a:1.0","b:b:2.0"));
        assertEquals( NextflowLoader.extendDepsWith("x:x:1.0 y:y:2.0", Arrays.asList("a:a:1.0", "b:b:2.0")), Arrays.asList("a:a:1.0","b:b:2.0","x:x:1.0","y:y:2.0"));
    }


    @Test
    public void testExtendClasspath() {
        assertEquals( NextflowLoader.extendClassPathWith(null, null), null );
        assertEquals( NextflowLoader.extendClassPathWith("x", null), Arrays.asList("x"));
        assertEquals( NextflowLoader.extendClassPathWith("x:y ", null), Arrays.asList("x","y"));
        assertEquals( NextflowLoader.extendClassPathWith("x :: y ", null), Arrays.asList("x","y"));
        assertEquals( NextflowLoader.extendClassPathWith("x:y:z", Arrays.asList("lib1.jar","lib2.jar")), Arrays.asList( "lib1.jar","lib2.jar","x","y","z"));

    }

}
