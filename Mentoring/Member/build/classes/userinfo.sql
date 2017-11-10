DROP TABLE USERINFO;

CREATE TABLE USERINFO (
		USERID VARCHAR2(20),
		PASSWORD VARCHAR2(20),
		NAME VARCHAR2(20),
		EMAIL VARCHAR2(40),
		PHONE VARCHAR2(40),
		CONSTRAINT USERINFO_PK PRIMARY KEY(USERID) 
	);
	
	INSERT INTO USERINFO(USERID, PASSWORD, NAME, EMAIL, PHONE) values (song, song, song, songaverom, 01088194231);

		-- �߰�!!! �Խ��� ����
DROP TABLE TB_BOARD_INFO;

CREATE TABLE TB_BOARD_INFO (
	BOARD_CODE VARCHAR2(20),	--���̺������ȣ
	WRITER VARCHAR2(20),	--�Խñ� �� ��� id
	PW VARCHAR2(20),	--�Խñۿ� �ش�Ǵ� ��й�ȣ(�˾ƾ� ����/���� ����)
	SUBJECT VARCHAR2(100),	--�Խñ� ����
	CONTENT VARCHAR2(4000),	--�Խñ� ����
	REGDATE VARCHAR(20),	--�Խñ� ��� �ð�
	READCOUNT NUMBER,	--�Խñ������� Ƚ��
	REPLYCOUNT NUMBER, --��� ����
	CONSTRAINT TB_BOARD_INFO_PK PRIMARY KEY(BOARD_CODE)
);

drop sequence board_seq;
create sequence board_seq;

--Ʈ����...�� ������ ����������..? �����Բ� ��������� �ϴ� �����ڵ� ������ ��� ������...
--DROP TRIGGER board_trigger;
--CREATE TRIGGER board_trigger BEFORE INSERT ON TB_BOARD_INFO FOR EACH ROW
--BEGIN
--	SELECT BOARD_SEQ.NEXTVAL INTO :new.BOARD_CODE FROM DUAL;
--END;


--TEST�� ���� �Խ���DB

INSERT INTO TB_BOARD_INFO(BOARD_CODE, WRITER, PW, SUBJECT, CONTENT, REGDATE, READCOUNT, REPLYCOUNT) VALUES ('BOARD000' || BOARD_SEQ.NEXTVAL, 'songmyung', '1234', '������ �θ��ϴ�  ��Ӵϴ� ¥����� �ȴٰ����~', 
'���� ���� �ϴ��̶� ���������� 
���� ���� ������ �� �ϳ� ���� 
�����ð� �⸣�ô� ��Ӵ� ���� 
Ǫ���ϴ� �� ���ٵ� ������ ���� 

�а� ���� �ٴٶ�� ���������� 
���� ���� ������ �� �ϳ� ���� 
����Ƕ� �̸��ô� ��Ӵ� ���� 
Ǫ���ٴ� �� ���ٵ� ���� �� ����', '2016-06-06', '0', '0');
INSERT INTO TB_BOARD_INFO(BOARD_CODE, WRITER, PW, SUBJECT, CONTENT, REGDATE, READCOUNT, REPLYCOUNT) VALUES ('BOARD000' || BOARD_SEQ.NEXTVAL, 'shm', '1234', '�޷��� �޷��� �ϴ� �޷�~~',
'�� ���ݾ� ������ ���󿡼� ���� ���� �ϴ� �� ��ŭ 
������ ������� �޸����� �μ� �� ��� 
�޷��� �޷��� �޷��� �ϴ�(�ϴ�) 
�̼��� ������(������) �޷��� �ϴ�(�ϴ�) 

�� ���ݾ� ���� ��� ���̴°� ���� �Ⱦ� �������ϱ� 
�ܷο� �������� �޸����� �ٶ�ó�� 
�޷��� �޷��� �޷��� �ϴ�(�ϴ�) 
�̼��� ������(������) �޷��� �ϴ�(�ϴ�) 

�� ���ݾ� �� ���� �ǹٸ��� ���� ��� �׷��� �̱��� 
��� ��� ��ġ�� �޸����� ���� ǰ���� 
�޷��� �޷��� �޷��� �ϴ�(�ϴ�) 
�̼��� ������(������) �޷��� �ϴ�(�ϴ�)(�ϴ�) ', '2016-06-06', '0', '0');
INSERT INTO TB_BOARD_INFO(BOARD_CODE, WRITER, PW, SUBJECT, CONTENT, REGDATE, READCOUNT, REPLYCOUNT) VALUES ('BOARD000' || BOARD_SEQ.NEXTVAL, 'eunjijiji', '1234', '�ϱ⸦ �Ế�ϴ�~~~~',
'���� ����� ��� ������ �˱� �ұ� 
���� ���� �� �ѹ��� �Ͼ�� 

������ �Ǹ��� �Ϸ� 
������ ���̱� �Ⱦ� �ǹ� ���� �� �ϴø� �ٶ�� 

�۰� ����� ��ƴ ���̷� 
���� ���� �� ū �ܷο��� �ٰ��� �� ��

*
�����߾� ���õ� 
�ƹ��� ���� ���Ŀ� ���� ���뵵 
�� �� ������, �����߾� ���õ� 

���� �ִٰ� �и� �ִٰ� 
�Ͼ��� �渶�� �帴���� ���� �� ��

�����߾� ���õ� (�����߾�)
�ƹ��� ���� ���Ŀ� ���� ���뵵 
�� �� ������, �����߾� �����߾� �����߾� ���õ�

�����߾� ���õ� (�����߾�)
�ƹ��� ���� ���Ŀ� ���� ���뵵 
�� �� ������, �����߾� ���õ� ', '2016-06-06 00:00', '0', '0');
INSERT INTO TB_BOARD_INFO(BOARD_CODE, WRITER, PW, SUBJECT, CONTENT, REGDATE, READCOUNT, REPLYCOUNT) VALUES ('BOARD000' || BOARD_SEQ.NEXTVAL, 'user5', '1234', 'subject5', 'content5', '2016-06-06', '0', '0');
INSERT INTO TB_BOARD_INFO(BOARD_CODE, WRITER, PW, SUBJECT, CONTENT, REGDATE, READCOUNT, REPLYCOUNT) VALUES ('BOARD000' || BOARD_SEQ.NEXTVAL, 'user6', '1234', 'subject6', 'content6', '2016-06-06', '0', '0');
INSERT INTO TB_BOARD_INFO(BOARD_CODE, WRITER, PW, SUBJECT, CONTENT, REGDATE, READCOUNT, REPLYCOUNT) VALUES ('BOARD000' || BOARD_SEQ.NEXTVAL, 'user7', '1234', 'subject7', 'content7', '2016-06-06', '0', '0');
INSERT INTO TB_BOARD_INFO(BOARD_CODE, WRITER, PW, SUBJECT, CONTENT, REGDATE, READCOUNT, REPLYCOUNT) VALUES ('BOARD000' || BOARD_SEQ.NEXTVAL, 'user8', '1234', 'subject8', 'content8', '2016-06-06', '0', '0');
INSERT INTO TB_BOARD_INFO(BOARD_CODE, WRITER, PW, SUBJECT, CONTENT, REGDATE, READCOUNT, REPLYCOUNT) VALUES ('BOARD000' || BOARD_SEQ.NEXTVAL, 'user9', '1234', 'subject9', 'content9', '2016-06-06', '0', '0');
INSERT INTO TB_BOARD_INFO(BOARD_CODE, WRITER, PW, SUBJECT, CONTENT, REGDATE, READCOUNT, REPLYCOUNT) VALUES ('BOARD000' || BOARD_SEQ.NEXTVAL, 'user10', '1234', 'subject10', 'content10', '2016-06-06', '0', '0');
INSERT INTO TB_BOARD_INFO(BOARD_CODE, WRITER, PW, SUBJECT, CONTENT, REGDATE, READCOUNT, REPLYCOUNT) VALUES ('BOARD000' || BOARD_SEQ.NEXTVAL, 'user11', '1234', 'subject11', 'content11', '2016-06-06', '0', '0');
INSERT INTO TB_BOARD_INFO(BOARD_CODE, WRITER, PW, SUBJECT, CONTENT, REGDATE, READCOUNT, REPLYCOUNT) VALUES ('BOARD000' || BOARD_SEQ.NEXTVAL, 'user12', '1234', 'subject12', 'content12', '2016-06-06', '0', '0');
INSERT INTO TB_BOARD_INFO(BOARD_CODE, WRITER, PW, SUBJECT, CONTENT, REGDATE, READCOUNT, REPLYCOUNT) VALUES ('BOARD000' || BOARD_SEQ.NEXTVAL, 'user13', '1234', 'subject13', 'content13', '2016-06-06', '0', '0');

--��۽�����
DROP SEQUENCE REPLY_SEQ;
CREATE SEQUENCE REPLY_SEQ;

--�߰�!!! �������
DROP TABLE TB_REPLY_INFO CASCADE CONSTRAINT;
CREATE TABLE TB_REPLY_INFO(
	REPLY_CODE VARCHAR2(20),
	BOARD_CODE  VARCHAR2(20),
	REPLYWRITER VARCHAR2(20),
	REPLYCONTENT VARCHAR2(200),
	REPLYREGDATE VARCHAR(20),
	CONSTRAINT TB_REPLY_INFO_PK PRIMARY KEY(REPLY_CODE)
);

--��¥DB
INSERT INTO TB_REPLY_INFO(REPLY_CODE, BOARD_CODE, REPLYWRITER, REPLYCONTENT, REPLYREGDATE) VALUES ('REPLY000' || REPLY_SEQ.NEXTVAL, 'BOARD0001', 'songmyung', '���ع��� ��λ��� ������ �⵵�� �ϴ����� �����ϻ� �츮���� ���� �������� ������ ���� ����', '2016-06-06 12:10');
INSERT INTO TB_REPLY_INFO(REPLY_CODE, BOARD_CODE, REPLYWRITER, REPLYCONTENT, REPLYREGDATE) VALUES ('REPLY000' || REPLY_SEQ.NEXTVAL, 'BOARD0001', 'id0103', '�����ٶ󸶹ٻ�^^ ������īŸ���K�� ���K�� �������K���K��!!!!!', '2016-06-06 12:10');
INSERT INTO TB_REPLY_INFO(REPLY_CODE, BOARD_CODE, REPLYWRITER, REPLYCONTENT, REPLYREGDATE) VALUES ('REPLY000' || REPLY_SEQ.NEXTVAL, 'BOARD0001', 'admin', '������ ���β��� ����� �վ sonymyung�̴� �۸��̸� ����� ����', '2016-06-16 12:10');
INSERT INTO TB_REPLY_INFO(REPLY_CODE, BOARD_CODE, REPLYWRITER, REPLYCONTENT, REPLYREGDATE) VALUES ('REPLY000' || REPLY_SEQ.NEXTVAL, 'BOARD0002', 'admin', 'coententnen....', '2016-06-06 12:10');
INSERT INTO TB_REPLY_INFO(REPLY_CODE, BOARD_CODE, REPLYWRITER, REPLYCONTENT, REPLYREGDATE) VALUES ('REPLY000' || REPLY_SEQ.NEXTVAL, 'BOARD0003', 'admin', 'coententnen....', '2016-06-06 12:10');
INSERT INTO TB_REPLY_INFO(REPLY_CODE, BOARD_CODE, REPLYWRITER, REPLYCONTENT, REPLYREGDATE) VALUES ('REPLY000' || REPLY_SEQ.NEXTVAL, 'BOARD0003', 'admin', 'coententnen....', '2016-06-06 12:10');

