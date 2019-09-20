

public class PokeCard {
    int val;
    String color;
    public PokeCard(int val,String color){
        this.val=val;
        this.color=color;
    }

    @Override
    public String toString() {
        //打印数字和颜色
        return String.format("[%d,%s]",val,color);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        //返回obj对象能否被PokeCard类型引用指向
        //obj对象的类型是不是PokeCard类型的小类型
        if(!(obj instanceof PokeCard)){
            return false;
        }
        //强制转换
        PokeCard other=(PokeCard)obj;
        //这里调用的是String类型的equals的（this.color是String类型的），已经实现好了
        return this.val==other.val
                &&this.color.equals(other.color);
    }
}



