import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {
//  DisplayName : 테스트 명을 구분지어줄 때 사용(선택 사항).
    @DisplayName("1+2는 3이다.")

//  Test : 해당 메소드가 테스트 메소드임을 알려줌.
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;

//      asserEquals : 기대값과 예상값을 비교해서 테스트 성공 여부 결정.
        Assertions.assertEquals(a+b, sum);
//        Assertions.assertEquals(a-b, sum);

    }
}
