import java.math.BigInteger;

class Solution {
    public long solution(int w, int h) {
        long area = (long) w * h;
        BigInteger b1 = BigInteger.valueOf(w);
        BigInteger b2 = BigInteger.valueOf(h);
        // w와 h의 최대공약수
        int gcd = b1.gcd(b2).intValue();

        // 전체 넓이에서 (넓이+높이-최대공배수) 값을 뺴준다.
        return (long) (area - (w + h - gcd));
    }
}