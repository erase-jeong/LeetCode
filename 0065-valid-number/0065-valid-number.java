class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // 부호는 맨 앞이거나, e/E 바로 다음에만 올 수 있음
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                // 점은 한 번만, 그리고 지수(e/E) 나온 뒤에는 올 수 없음
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                // e는 한 번만, 그리고 e 앞에 숫자가 최소 하나는 있어야 함
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; // e 뒤에도 숫자가 반드시 있어야 하므로 리셋
            } else {
                // 그 외 문자(알파벳, 공백 등)는 전부 무효
                return false;
            }
        }

        return seenDigit;
    }
}

/*
1. 정수 뒤에 선택적으로 지수가 올 수 있음 (선택)
2. 소수점 이하 자릿수 뒤에 선택적으로 지수 붙음 (선택)
3. (정수) -정수, +정수
4. (소수) -소수, +정수
    - 숫자.
    - 숫자.숫자
    - .숫자
    - 
5. 지수 => 지수 표기법 or e, E 뒤에 정수가 옴
6. 숫자는 하나 이상의 숫자로 정의함
*/