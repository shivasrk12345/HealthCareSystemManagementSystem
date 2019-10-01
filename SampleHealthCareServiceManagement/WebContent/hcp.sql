create table hcp_groupb
(
hcpId number(5) primary key,
password varchar2(30)not null,
hcpName varchar2(30) not null,
licenseNumber varchar2(10) not null,
address varchar2(100) not null,
contactNumber number(10)unique,
alernateContactnumber number(10) not null,
email varchar2(30) not null,

question1 varchar2(50) not null,
answer1 varchar2(20) not null,
question2 varchar2(50) not null,
answer2 varchar2(20) not null

);

create sequence hcpid start with 501 increment by 1 nocycle;


select * from HCP_groupb
delete from hcp_groupb where hcpID=514

drop table hcp_groupb

drop sequence hcpid




create table Patient_13455624(
patientId number(4) primary key,
patientPassword varchar2(15) not null,
FirstName varchar2(30) not null,
LastName varchar2(30) not null,
Gender varchar2(10) not null check(Gender='Male' or Gender='Female'),
Age number(4) not null,
Address varchar2(100) not null,
ContactNumber number(10) not null,
Complaint varchar2(100),
Doctor varchar2(15),
InsuranceCover varchar2(15) check(InsuranceCover='Yes' or InsuranceCover='No') not null,
HealthInsuranceNumber number(10) not null,
yourbirthcity varchar2(15),
yourfavoriteactor varchar2(15),
yourfavoritefood varchar2(15),
yourfavoritecrickter varchar2(15),
yourfavoritesport varchar2(15),

hcpId number(5)
)


create table Patientpayment(patientId number(4),
							paymentStatus varchar2(25) not null)
							
alter table Patientpayment add constraint fk1_krishnapay_1358321 foreign key(patientId) references  Patient_13455624(patientId);

							
							
alter table Patient_13455624 drop column paymentStatus;
create sequence pidgen_B1 start with 101 increment by 1

drop sequence pidgen_B1


create sequence pidpswdgen_B1 start with 225 increment by 1


drop sequence pidpswdgen_B1

delete from Patient_13455624
drop table Patient_13455624

select * from Patient_13455624

 select patientPassword,ContactNumber from Patient_13455624 where patientId=111
 
 
 select patientId,patientPassword,FirstName,LastName from Patient_13455624 where patientId=0 or ContactNumber=7410025896

987542

select pidgen_B1.nextval from dual
select pidpswdgen_B1.nextval from dual




create table dependant_13455624(
patientId number(4) ,
Name varchar2(30) not null,
relationship varchar2(30) not null check(relationship='Child' or relationship='Spouse' or relationship='Father' or relationship='Mother'),
Gender varchar2(10) not null check(Gender='Male' or Gender='Female'),
Age number(4) not null,
Address varchar2(100) not null,
ContactNumber number(10) not null,
InsuranceCover varchar2(15) check(InsuranceCover='Yes' or InsuranceCover='No') not null,
HealthInsuranceNumber number(10) not null
)
 drop table dependant_13455624
 select * from dependant_13455624


alter table dependant_13455624 add constraint fk_1345562 foreign key(patientId) references Patient_13455624(patientId) on delete cascade;
 alter table Patient_13455624 add constraint fk1_1345562 foreign key(hcpId)references hcp_groupb(hcpId);

select hcpId from hcp_groupb;



create table lsp_1390
(
LabId number(5) primary key,
LSPName varchar2(30) not null,
Address varchar2(100) not null,
Zipcode number(8) not null,
State varchar2(20) not null,
City varchar2(20) not null
);

create table test_1390
(
LabId number(5),foreign key(LabId) references lsp_1390(LabId),
TestName varchar2(30) not null,
TestCode varchar2(20) not null,
TestDescription varchar2(100) not null,
TestDuration varchar2(30) not null,
TestCost number(10,2) not null,
LabHome varchar2(5) not null
);

select * from test_1390;
select * from lsp_1390;

drop table lsp_1390

insert into lsp_1390 values(64627,'DDRC','DY patil',421201,'maharashtra','dombivli');
insert into lsp_1390 values(12345,'Nucleus','AJ hospital',700652,'Pune','mumbai');
insert into lsp_1390 values(29876,'OM scan Center','Karwa hospital',735662,'Kerala','thane');
insert into lsp_1390 values(37363,'PathLab','JJ hospital',724552,'Tamilnadu','kalyan');
insert into lsp_1390 values(59521,'Icon','Medical college Jn',724552,'Rajasthan','diva');
insert into lsp_1390 values(43419,'Cells','MGM medical college',714562,'Gujrat','mulund');

insert into test_1390 values(64627,'skin','1234','treatment','1 hour',1000.0,'yes');
insert into test_1390 values(12345,'eyes','111','eye sight correction','1 hour',1000.0,'No');
insert into test_1390 values(12345,'eyes','111','eye sight correction','1 hour',1000.0,'yes');
insert into test_1390 values(29876,'nose','222','nose treatment','2 hours',2000.0,'Yes');
insert into test_1390 values(37363,'ears','333','ear treatment','30 minutes',3000.0,'No');
insert into test_1390 values(43419,'skin','444','skin treatment','3 hours',4000.0,'Yes');


select l.LSPName,l.Address,l.Zipcode,l.State,l.City,t.TestName,t.TestCode,t.TestDescription,t.TestDuration,
t.TestCost,t.LabHome from lsp_1390 l , test_1390 t   where t.TestName='skin' and l.LabId=t.LabId






