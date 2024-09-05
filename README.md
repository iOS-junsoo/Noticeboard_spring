# [NoticeBoard]

이 프로젝트는 스프링부트를 사용해서 게시판 서버를 구현한 iOS 앱입니다. 
이 앱의 서버는 H2 데이터베이스와 연결되어 있고, 사용자가 게시글을 만들고 댓글 작성 기능을 제공합니다.

## 기능 🏗️

- **게시글 추가**: 사용자가 새로운 게시글을 추가할 수 있습니다.
- **게시글  조회**: 사용자가 추가한 게시글을 조회할 수 있습니다.
- **댓글 추가**: 사용자가 기존에 등록된 게시글에 댓글을 작성할 수 있습니다.
- **게시글  삭제**: 사용자가 게시글을 삭제할 수 있습니다.

## 기술 스택 🛠️

- **프레임워크**: Spring Boot
- **데이터베이스**: H2
- **빌드 도구**: Gradle
- **기타 라이브러리**: Spring Data JPA, H2 Database, JUnit

## API 문서 📃

- **POST /post**: 새로운 게시글을 추가합니다.
  - 요청 바디: `{"title": "할 일 제목", "content": "할 일 설명", "author": "할 일 설명"}`
  - 응답: 추가된 게시글 객체

- **GET /post**: 모든 게시글을 조회합니다.
  - 응답: 할 일 객체 배열

- **PUT /post/{postId}/addComment**: 특정 게시글의 댓글을 추가합니다.
  - 요청 바디: `{"content": "할 일 설명", "author": "할 일 설명"}`
  - 응답: x

- **DELETE /post/{id}/delete**: 특정 할 일을 삭제합니다.

## 화면 구성 📱

<p align="center">
  <img src="https://github.com/user-attachments/assets/018485e2-31e7-4305-a1b8-c718e822b462" width="200" height="auto" alt="Image 1" style="display:inline-block; margin:5px;">
  <img src="https://github.com/user-attachments/assets/8a9009d3-42a1-45c0-9584-21faa4ec1f49" width="200" height="auto" alt="Image 2" style="display:inline-block; margin:5px;">
  <img src="https://github.com/user-attachments/assets/9362efe7-4b69-44ba-bb78-5bc6d41ad95e" width="200" height="auto" alt="Image 1" style="display:inline-block; margin:5px;">
  <img src="https://github.com/user-attachments/assets/8c3dfbfa-dffa-49bb-a788-c4d33a38a917" width="200" height="auto" alt="Image 4" style="display:inline-block; margin:5px;">
</p>

