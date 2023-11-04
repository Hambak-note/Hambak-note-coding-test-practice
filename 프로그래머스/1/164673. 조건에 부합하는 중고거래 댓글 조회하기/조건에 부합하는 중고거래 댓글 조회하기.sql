-- 코드를 입력하세요
-- 조건: 2022년 10월
-- 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일
-- 댓글 작성일 기준 오름차순, 작성일이 같다면 게시글 제목을 기준으로 오름차순
SELECT 
    tb_ugb.TITLE
    , tb_ugb.BOARD_ID
    , tb_ugr.REPLY_ID
    , tb_ugr.WRITER_ID
    , tb_ugr.CONTENTS
    , DATE_FORMAT(tb_ugr.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
FROM USED_GOODS_BOARD tb_ugb 
    JOIN USED_GOODS_REPLY tb_ugr ON tb_ugb.BOARD_ID = tb_ugr.BOARD_ID
WHERE 1=1
    AND tb_ugb.CREATED_DATE >= '20221001' AND tb_ugb.CREATED_DATE < '20221101'
ORDER BY tb_ugr.CREATED_DATE ASC, tb_ugb.TITLE ASC





