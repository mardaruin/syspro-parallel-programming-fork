package org.nsu.syspro.parprog.stress.basic;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;
import org.openjdk.jcstress.infra.results.II_Result;

import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE;
import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE_INTERESTING;

@JCStressTest
@Outcome(id = "0", expect = ACCEPTABLE_INTERESTING, desc = "All increments lost")
@Outcome(id = "1", expect = ACCEPTABLE, desc = "Four increments lost")
@Outcome(id = "2", expect = ACCEPTABLE, desc = "Three increments lost")
@Outcome(id = "3", expect = ACCEPTABLE, desc = "Two increments lost")
@Outcome(id = "4", expect = ACCEPTABLE, desc = "One increment lost")
@Outcome(id = "5", expect = ACCEPTABLE, desc = "All increments applied")
@State
public class TestConcurrentIncrements {
    int v;

    @Actor public void actor1(I_Result r) { ++v; }
    @Actor public void actor2(I_Result r) { ++v; }
    @Actor public void actor3(I_Result r) { ++v; }
    @Actor public void actor4(I_Result r) { ++v; }
    @Actor public void actor5(I_Result r) { ++v; }

    @Arbiter
    public void arbiter(I_Result r) {
        r.r1 = v;
    }
}


//@JCStressTest
//@Outcome(id = "1, 1", expect = ACCEPTABLE_INTERESTING, desc = "Data race")
//@Outcome(id = "1, 2", expect = ACCEPTABLE, desc = "actor1 -> actor2.")
//@Outcome(id = "2, 1", expect = ACCEPTABLE, desc = "actor2 -> actor1.")
//@State
//public class TestConcurrentIncrements {
//    int v;
//    @Actor public void actor1(II_Result r) {
//        r.r1 = ++v;
//    }
//    @Actor public void actor2(II_Result r) {
//        r.r2 = ++v;
//    }
//}