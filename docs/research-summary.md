# 조사 요약

## 현업 예약 시스템에서 가져온 기준

| 조사 대상 | 반영한 점 |
|---|---|
| Google Calendar resources | 건물, 층, 방, 장비/특징을 구조화해 검색 가능하게 관리 |
| Microsoft Places room analytics | 예약 데이터와 실제 사용 데이터를 구분하고, 공간 사용률/노쇼 분석을 운영 지표로 사용 |
| Skedda check-in | 체크인 창, 미체크인 시 예약 해제, 활동 로그 기록 |
| Robin abandoned meeting protection | 기본 10분 노쇼 임계값, QR/앱/화면 기반 체크인, 방 자동 해제 |
| Maven standard layout | `src/main/java`, `src/main/resources`, `src/test/java` 구조 |
| Java Socket/HTTP server model | 클라이언트와 서버가 네트워크를 통해 분리되는 구조 |
| JUnit 5 | 핵심 정책을 단위 테스트로 검증 |

## 이번 프로젝트에 맞춘 결정

- 웹이 아니라 Java Swing 클라이언트를 사용한다.
- 서버는 Java 기본 HTTP 서버로 시작한다.
- 데이터베이스는 쓰지 않고 YAML 파일 저장소를 기준으로 둔다.
- 외부 라이브러리 의존을 최소화해 NetBeans/Maven에서 열기 쉽게 한다.
- 도메인 정책은 `common/policy`에 두어 테스트하기 쉽게 만든다.

## 참고 링크

- [Google Calendar domain resources, rooms & calendars](https://developers.google.com/workspace/calendar/api/concepts/domain)
- [Google Workspace Admin Help: Create buildings, features & Calendar resources](https://support.google.com/a/answer/1033925?hl=en-EN)
- [Microsoft Places room analytics](https://learn.microsoft.com/en-us/microsoft-365/places/room-analytics)
- [Skedda check-in](https://support.skedda.com/en/articles/5242690-check-in)
- [Robin abandoned meeting protection](https://support.robinpowered.com/hc/en-us/articles/360032675532-Abandoned-meeting-protection)
- [Maven standard directory layout](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)
- [Oracle Java sockets tutorial](https://docs.oracle.com/javase/tutorial/networking/sockets/)
- [JUnit 5 user guide](https://junit.org/junit5/docs/5.10.3/user-guide/index.html)
