import org.junit.jupiter.api.*;

public class JUnitCycleTest {

    @BeforeAll // 전체 테스트 시작 전 1회 시행. static 선언.
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }
    @BeforeEach // 매 테스트 케이스 시작 전 실행.
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }
    @Test
    public void test1() {
        System.out.println("test1");
    }
    @Test
    public void test2() {
        System.out.println("test2");
    }@Test
    public void test3() {
        System.out.println("test3");
    }
    @AfterEach()
    public void afterEach() {
        System.out.println("@AfterEach");
    }

    @AfterAll() // 전체 테스트 끝난 뒤 1 번 실행.
    static void afterAll() {
        System.out.println("@AfterAll");
    }
}
