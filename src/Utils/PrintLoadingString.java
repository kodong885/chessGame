package Utils;

public class PrintLoadingString {

    public void PrintLoadingString() {
        String[] animation = {"|", "/", "-", "\\"};
        int totalSeconds = 2; //
        int interval = 100; // 0.1초마다 업데이트
        int loops = totalSeconds * 1000 / interval; // 총 반복 횟수

        try {
            System.out.print("로딩 중... ");

            for (int i = 0; i < loops; i++) {
                System.out.print("\b" + animation[i % animation.length]); // \b(backspace - 바로 앞의 문자를 하나 지움)로 이전 문자 지우고, 애니메이션 출력
                Thread.sleep(interval); // 잠시 대기
            }

            System.out.print("\b"); // 마지막 애니메이션 문자 지우기
            System.out.println("완료! ✅"); // 완료 메시지 출력

        } catch (InterruptedException e) {
            System.err.println("로딩 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

}
