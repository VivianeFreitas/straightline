package absyn;

import io.vavr.collection.Tree;

import java.util.Map;

public class CompoundStm extends Stm {

   public final Stm stm1;
   public final Stm stm2;

   public CompoundStm(Stm stm1, Stm stm2) {
      this.stm1 = stm1;
      this.stm2 = stm2;
   }

   @Override
   public Tree.Node<String> toTree() {
      return Tree.of("CompoundStm", stm1.toTree(), stm2.toTree());
   }

   @Override
   public int maxargs() {
      return Math.max(stm1.maxargs(), stm2.maxargs());
   }

   @Override
   public void interp(Map<String, Double> mem) {
      stm1.interp(mem);
      stm2.interp(mem);
   }
}
