package com.wh.treedemo01;




//priciple define
public class RBTreeDemo1 <T extends Comparable<T> >{

    private RBTNode<T> mRoot;//根节点
    private static final boolean RED=false;
    private static final boolean BLACK=true;


    public class RBTNode<T extends Comparable<T>>{

        boolean color;//颜色
        T key;//关键字，键值
        RBTNode<T> left;//左孩子
        RBTNode<T>right;//右孩子
        RBTNode<T>parent;//父节点

        //定义节点的值
        public RBTNode(boolean color, T key, RBTNode<T> left,//
                       RBTNode<T> right, RBTNode<T> parent) {
            this.color = color;
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "RBTNode{" +
                    "key=" + key +(this.color==RED?"RED":"BLACK")
                    +"}";
        }


    }

    public RBTreeDemo1(){
        mRoot=null;
    }

    private RBTNode<T>parentOf(RBTNode<T> node){

        return node!=null?node.parent:null;


    }

    private boolean colorOf(RBTNode<T> node){
        return node!=null?node.color:BLACK;
    }
    private boolean isRed(RBTNode<T> node){
        return ((node!=null)&&(node.color==RED))?true:false;

    }

    private boolean isBlack(RBTNode<T>node){
        //return !isRed();
        return ((node!=null)&&(node.color==BLACK))?true:false;
    }

    private void setColor(RBTNode<T> node,boolean color) {
        //this.color = color;
        if (node!=null)node.color=color;
    }

    private void setBlack(RBTNode<T> node ){
        if (node!=null)node.color=BLACK;
    }
    private void setRed(RBTNode<T> node){

        if (node!=null)node.color=RED;
    }

    private void setParent(RBTNode<T> node,RBTNode<T> parent) {
        //this.parent = parent;
        if (node!=null)node.parent=parent;
    }


    /**
     *
     * 前序遍历“红黑树”
     * */
    private void preOrder(RBTNode<T> tree){
        if (tree!=null){
            System.out.print(tree.key+"");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder(){
        preOrder(mRoot);
    }

    /**
     *
     *中序遍历“红黑树”
     * */
    private  void inOrder(RBTNode<T> tree){
        if (tree!=null){
            inOrder(tree.left);
            System.out.print(tree.key+"");
            inOrder(tree.right);
        }
    }

    public void inOrder(){
        inOrder(mRoot);
    }

    /**
     *
     *后序遍历“二叉树”
     * */
    private void postOrder(RBTNode<T> tree){
        if (tree!=null){
            postOrder(tree.left);
            System.out.print(tree.key+" ");
            postOrder(tree.right);
        }
    }

    /**
     *
     *递归实现 查找“红黑树x”中键值key的结点
     * */
    private RBTNode<T>search(RBTNode<T>x,T key){


        if (x==null)return x;
        int cmp=key.compareTo(x.key);
        if (cmp<0){
            return search(x.left,key);
        }else if (cmp>0){
            return search(x.right,key);
        }else {
            return x;
        }
    }

//提供一个对外查询的方法，传入要查询的值
    public RBTNode<T> search(T key) {
        return search(mRoot,key);
    }


    /**
     *
     *（非递归实现）查找“红黑树x”中键值为key的结点
     * */
    private RBTNode<T> iterativeSearch(RBTNode<T> x,T key){
        while (x!=null){
            int cmp=key.compareTo(x.key);
            if (cmp<0)x=x.left;
            else if(cmp>0)x=x.right;
            else return x;
        }
        return x;

    }

    //提供一个对外访问的方法，为public


    public RBTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot,key);
    }

    //查找最小的结点：返回tree为根节点的红黑树的最小结点
    private RBTNode<T>minimum(RBTNode<T>tree){

        if (tree!=null)return tree;
        while (tree.left!=null)tree=tree.left;
        return tree;

    }
    //提供一个对外访问的查找最小节点的共有方法
    public T minimum(){
        RBTNode<T>p=minimum(mRoot);
        if (p!=null)return p.key;
        return null;
    }


    //查找最大的结点
    private RBTNode<T> maximum(RBTNode<T> tree){
        if (tree==null)return null;
        while (tree.right!=null)tree=tree.right;
        return  tree;
    }


    public T maximum(){
        RBTNode<T>p=maximum(mRoot);
        if (p!=null)return p.key;
        return null;
    }

    /**
     *
     根节点：
     找根节点(x)的后继结点，查找
     “红黑树中数据项值大于该节点”
     的“最小节点”

     * */

    public RBTNode<T> successor(RBTNode<T> x){
        //如果x存在右孩子，则"x的后继结点"为
        //"以其右孩子为根的子树的最小节点"
        if (x.right!=null)return minimum(x.right);

        //如果x没有右孩子，则x有以下两种可能：
        //(01)x是一个“左孩子”，则“x的后继结点”为“它的父节点”
        //（02）x是一个“右孩子”，则查找“x的最低父节点”,
        //“并且该父节点要具有左孩子”，则找到这个“最低父节点”就是"x的后继结点"
        RBTNode<T>p=x.parent;
        while ((p!=null)&&(x==p.right)){
            x=p;
            p=p.parent;

        }
        return p;
    }

    /**
     *
     找结点（x）的前驱结点。即，查找“红黑树中数值小于该节点”的“最大节点”


     * */


    public RBTNode<T>presuccessor(RBTNode<T> x){
        //如果x，存在左孩子，则“x的后继节点”为“以其左孩子为根的子树的的最小的结点”
        if (x.left!=null)return minimum(x.left);
        //如果x没有左孩子，则有如下的两种可能的情况：
        //(01)x是一个右孩子，则“x的后继节点”为“它的父节点”
        //(02)x是一个左孩子，则“x的后继节点”为“x的最低父节点”，
        RBTNode<T> p=x.parent;
        while ((p!=null)&&(x==p.left)){
            x=p;
            p=p.parent;
        }
        return  p;
    }


    /**
     *
     /*
     对红黑树的节点(x)进行左旋转

         左旋示意图(对节点x进行左旋)：
          px                              px
          /                               /
        x                               y
       /  \        --(左旋)-.           /   \                #
      lx   y                          x     ry
          /   \                     /  \
       ly   ry                    lx  ly

     * */
    private  void leftRotate(RBTNode<T>x){
        //设置x的右孩子为y
        RBTNode<T>y=x.right;
        //将“y的左孩子”设为"x的右孩子"
         //如果y的左孩子非空，将"x"设为“y的左孩子的父亲”
        x.right=y.left;//十分精炼
        if (y.left!=null)
        {
            y.left.parent=x;
        }

        //将"x的父亲"设置为"y的父亲"
        y.parent=x.parent;
        if (x.parent==null){
            //如果“x的父亲”是空节点，则将y设置为根节点
            this.mRoot=y;
        }else {
            if (x.parent.left==x){
                // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”

                x.parent.left=y;
            }else
            {// 如果 x是它父节点的右孩子，则将y设为“x的父节点的右孩子”
                x.parent.right=y;
            }
        }

        // 将 “x” 设为 “y的左孩子”
          y.left = x;
           // 将 “x的父节点” 设为 “y”
        x.parent=y;


    }


//    对红黑树的节点(y)进行右旋转
//
//    右旋示意图(对节点y进行左旋)：
//            py                               py
//           /                                /
//          y                                x
//         /  \      --(右旋)-.            /  \                     #
//        x   ry                          lx   y
//       / \                                   / \                   #
//     lx  rx                                 rx  ry


    private void rightRotate(RBTNode<T> y) {
        //设置x是当前节点的左孩子
        RBTNode<T>x=y.left;
        //将"x的右孩子"，设置为"y的左孩子"
        //如果"x的右孩子"不为空的话，将"y"设置为"x右孩子"的父亲
        y.left=x.right;
        if (x.right!=null){
            x.right.parent=y;
        }
        //将"y的父亲"设置为"x的父亲"
        x.parent=y.parent;
        if (y.parent==null){
            this.mRoot=x;//如果 “y的父亲” 是空节点，则将x设为根节点
        }else{
            if (y==y.parent.left){
                y.parent.left=x;// 如果 y是它父节点的右孩子，则将x设为“y的父节点的右孩子”
            }else {
                y.parent.right=x;// (y是它父节点的左孩子) 将x设为“x的父节点的左孩子”
            }
        }
        // 将 “y” 设为 “x的右孩子”
              x.right = y;

             // 将 “y的父节点” 设为 “x”

        y.parent=x;


    }


     /*
     * 销毁红黑树
      */
     private void destroy(RBTNode<T> tree){
         if (tree==null)return;
         if (tree.left!=null)
             destroy(tree.left);
         if (tree.right!=null)
             destroy(tree.right);
         tree=null;
     }

     public void clear(){
         destroy(mRoot);
         mRoot=null;
     }

     /*
    * 打印"红黑树"
      *
     * key        -- 节点的键值
    * direction  --  0，表示该节点是根节点;
    *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
     private void print(RBTNode<T> tree, T key, int direction) {

                if(tree != null) {

                   if(direction==0)    // tree是根节点
                         System.out.printf("%2d(B) is root\n", tree.key);
                   else                // tree是分支节点
                      System.out.printf("%2d(%s) is %2d's %6s child\n", tree.key, isRed(tree)?"R":"B", key, direction==1?"right" : "left");

                  print(tree.left, tree.key, -1);
                    print(tree.right,tree.key,  1);
              }
        }


        public void print(){
         if (mRoot!=null)
             print(mRoot,mRoot.key,0);
        }



     /*
   * 红黑树插入修正函数
     *
     * 在向红黑树中插入节点之后(失去平衡)，再调用该函数；
      * 目的是将它重新塑造成一颗红黑树。
     *
    * 参数说明：
     *     node 插入的结点
      */






}
