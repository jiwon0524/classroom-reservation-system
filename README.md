# Classroom Reservation System

정보관 1층부터 9층까지의 강의실 예약을 관리하는 Java Swing 클라이언트 / Java HTTP 서버 구조의 소프트웨어공학 프로젝트입니다.

DB를 사용하지 않고 파일 저장소를 전제로 하며, 학생 / 교수 / 관리자 역할을 기준으로 예약, 승인, 체크인, 노쇼 방지, 시설 상태 관리 기능을 나누어 설계했습니다.

## Modules

| Module | Role |
|---|---|
| `reservation-common` | 공통 도메인 모델, 정책, API 경로 |
| `reservation-server` | 서버 실행, API 핸들러, 서비스, 파일 저장소 |
| `reservation-client` | Swing 화면, 컨트롤러, 서버 API 호출 |

## Run Direction

1. 서버 실행: `reservation-server`의 `ClassroomReservationServer`
2. 클라이언트 실행: `reservation-client`의 `ClassroomReservationClient`
3. 기본 서버 주소: `http://localhost:8080`

## Implementation Order

1. 로그인과 역할별 권한
2. 강의실 조회와 시설 정보 표시
3. 예약 신청과 충돌 검사
4. 관리자 승인 / 거부 / 취소
5. 체크인과 노쇼 처리
6. 시설 신고와 운영 공지
7. 백업 / 복구와 사용률 통계
