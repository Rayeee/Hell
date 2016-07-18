package winter.hell.redis.utils;

/**
 * 两个相对相关的数据，包装在一个对象中，用于方便参数传递，返回值。
 * 
 * 
 * 
 * @param <A>
 * first的数据类型
 * @param <B>
 * second的数据类型
 */
public class Pair<A, B> {
    public final A first;
    public final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}

	public A getFirst() {
		return first;
	}

	public B getSecond() {
		return second;
	}
    
}
