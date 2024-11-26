-- 코드를 입력하세요
SELECT 
        d.dr_name as DR_NAME, 
        d.dr_id as DR_ID, 
        d.mcdp_cd as MCDP_CD, 
        DATE_FORMAT(d.hire_ymd, '%Y-%m-%d') as HIRE_YMD
from doctor d
where d.mcdp_cd = 'CS' or d.mcdp_cd = 'GS'
order by hire_ymd desc, dr_name asc