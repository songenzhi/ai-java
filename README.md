# 🎨 Colorful Simple Calculator

Java Swing을 활용한 **색상 테마가 적용된 간단한 계산기**입니다.  
두 숫자를 입력받아 덧셈, 뺄셈, 곱셈, 나눗셈을 수행하고 결과를 메시지 다이얼로그로 보여줍니다.  
인터넷에서 계산기 아이콘을 불러와 UI를 더 생동감 있게 구성했습니다.

---

## 📁 프로젝트 구조

```
SimpleCalculator/
├── src/
│   └── test/
│       └── SimpleCalculator.java
├── README.md
└── .gitignore
```

**설명**  
- `src/test/SimpleCalculator.java` — 메인 클래스 (패키지 `test` 사용)  
- 단일 파일 프로젝트로 구성되어 있습니다.

---

## 🚀 실행 방법

1. **JDK 8 이상**이 설치되어 있어야 합니다.
2. `src/test/SimpleCalculator.java` 파일을 생성하고 코드를 작성합니다.
3. 컴파일 및 실행:

```bash
javac src/test/SimpleCalculator.java
java -cp src test.SimpleCalculator
```

**IDE 추천**: IntelliJ IDEA, Eclipse, VS Code에서 바로 실행하는 것을 권장합니다.

---

## 💡 주요 기능

- 덧셈, 뺄셈, 곱셈, 나눗셈 지원
- 0으로 나누기 방지 처리
- 숫자 입력 유효성 검사
- SwingWorker를 이용한 비동기 이미지 로딩
- 예쁜 색상 테마 적용 (Alice Blue, Lavender 등)
- 반응형 버튼 디자인

---

## 📖 주요 개념 설명

### 1. Swing GUI 컴포넌트
- `JFrame`, `JPanel`, `JButton`, `JTextField`, `JLabel`, `JOptionPane` 등 사용
- 레이아웃 매니저: `BorderLayout`, `GridLayout`, `FlowLayout`

### 2. 이벤트 처리
- 하나의 `ActionListener`를 모든 연산 버튼이 공유하여 코드 중복 최소화

### 3. 백그라운드 이미지 로딩
- `SwingWorker` 클래스를 사용하여 네트워크 이미지 로딩 시 UI가 멈추지 않도록 처리

### 4. 예외 처리
- `NumberFormatException`: 잘못된 숫자 입력 처리
- 0으로 나누는 경우 사용자 친화적 에러 메시지 출력

### 5. UI 디자인
- 다양한 색상 팔레트 적용
- `BorderFactory`를 이용한 테두리와 여백 설정
- 버튼별 개성 있는 색상 지정

---

## 📚 참고 자료

- [Oracle Java Swing 공식 튜토리얼](https://docs.oracle.com/javase/tutorial/uiswing/)
- [Swing Layout Managers](https://docs.oracle.com/javase/tutorial/uiswing/layout/using.html)
- [SwingWorker 설명](https://docs.oracle.com/javase/tutorial/uiswing/concurrency/worker.html)
- [Icons8 무료 아이콘](https://icons8.com/)
- [Baeldung - Java Swing Best Practices](https://www.baeldung.com/java-swing-best-practices)

---

## 🔧 향후 개선 아이디어

- 키보드 입력 지원 (Enter 키로 계산)
- 계산 기록(History) 기능
- 다크 모드 테마 추가
- 메뉴 바(Menu Bar) 구현
- Maven 또는 Gradle 프로젝트로 변환

---


