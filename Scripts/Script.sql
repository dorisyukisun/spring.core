select e.eid, e.name, e.age, e.createtime,
       j.jid as jod_jid, j.kname as job.jname, j.eid as job_eid
from emp e left join job j on j.eid = e.eid;