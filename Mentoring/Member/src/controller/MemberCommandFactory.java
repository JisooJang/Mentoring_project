package controller;

import controller.action.*;

public class MemberCommandFactory {
	private MemberCommandFactory(){
	}
	public static MemberCommandFactory getInstance(){
		return new MemberCommandFactory();
	}
	public Action getAction(String command) throws IllegalCommandException{
		Action action = null;
		
		if (command.equals("list")) {
			action = new ListAction();
		} else if (command.equals("view")) {
			action = new ViewAction();
		} else if (command.equals("insert")) {
			action = new InsertAction();
		} else if (command.equals("update")) {
			action = new UpdateAction();
		} else if (command.equals("delete")) {
			action = new DeleteAction();
		} else if (command.equals("login")) {
			action = new LoginAction();
		} else if (command.equals("updateForm")) {
			action = new UpdateFormAction();
		} else if (command.equals("insertForm")) {
			action = new InsertFormAction();
		} else if (command.equals("loginForm")) {
			action = new LoginFormAction();
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		} else if (command.equals("searchPartner")) {
			action = new SearchPartnerAction();
		} else if (command.equals("retrieveBoardList")){
			action = new RetrieveBoardListAction();
		} else if (command.equals("boardCreate")) {
			action = new BoardCreateAction();
		} else if (command.equals("retrieveBoard")) {
			action = new RetrieveBoardAction();
		} else if (command.equals("retrieveReplyList")) {
			action = new RetrieveReplyListAction();
		} else if (command.equals("replyCreate")) {
			action = new ReplyCreateAction();
		} else if (command.equals("retrieveBoardIn")) {
			action = new retrieveBoardInAction();
		} else if (command.equals("teamDiary")) {   //�� ���̾ �޴� Ŭ����, ���Ե� �� ��� ���
	         action = new TeamDiaryAction();
	      } else if (command.equals("team_board_list")) {   //�� �Խñ� ����Ʈ ���
	         action = new TeamBoardListAction();
	      } else if (command.equals("team_board_update")) {   //�� �Խñ� ����
	         action = new TeamBoardUpdateAction();
	      } else if (command.equals("team_board_modify")) {   //�� �Խñ� ����
	         action = new TeamBoardModifyAction();
	      }else if (command.equals("team_board_view")) {   //�� �Խñ� ����
	         action = new TeamBoardViewAction();
	      } else if (command.equals("team_board_write")) {   //�� �Խñ� �ۼ�
	         action = new TeamBoardCreateAction();
	      } else if (command.equals("team_board_remove")) {   //�� �Խñ� �ۼ�
	         action = new TeamBoardRemoveAction();
	      } else if (command.equals("team_calendar_list")) {   //�� ���� �޷� ���
	         action = new TeamCalendarListAction();
	      } else if (command.equals("team_calendar_write")) {      //�� ���� �޷� �ۼ� (Ư�� ��¥����)
	         action = new TeamCalendarWriteAction();
	      } else if (command.equals("team_calendar_update")) {   //�� ���� �޷� ���� ������ (Ư�� ��¥����)
	         action = new TeamCalendarUpdateAction();
	      } else if (command.equals("team_calendar_view")) {      //�� ���� ����
	         action = new TeamCalendarViewAction();
	      } else if (command.equals("team_calendar_remove")) {   //�� ���� ����
	         action = new TeamCalendarRemoveAction();
	      } else if (command.equals("team_calendar_modify")) {   //�� ���� ���� ����(���� ���������� ������ư)
	         action = new TeamCalendarModifyAction();
	      } else if (command.equals("team_member_list")) { //�� ��� �ּҷ� ���
	         action = new TeamMemberListAction();
	      } else if(command.equals("team_twitter")) {
	         action = new TeamTwitterAction();
		} else if(command.equals("team_main")) {   // �� ���̾ ���� ������ (�� ����)
	         action = new TeamMainAction();
	      }
	      else if (command.equals("team_insert")){
			action = new TeamInsertAction();
		} else if (command.equals("random")){
			action = new RandomPartnerAction();
		}else if (command.equals("applyCreate")) {
			action = new applyCreateAction();
		} else if (command.equals("teamMemberCreate")) {
			action = new teamMemberCreateAction();
		} else if (command.equals("retrieveTeamList")) {
			action = new retrieveTeamListAction();
		} else if (command.equals("RetrieveApplyList")) {
			action = new RetrieveApplyListAction();
		} else if (command.equals("applyRemove")) {
			action = new applyRemoveAction();
		} else if (command.equals("RetrieveTeamMemberList")) {
			action = new RetrieveTeamMemberListAction();
		} else if (command.equals("retrieveApplyListByMemeber_id")) {
			action = new retrieveApplyListByMemeber_idAction();
		} else if (command.equals("NotiBoardWrite")){
			action = new NotiBoardWriteAction();
		} else if (command.equals("NotiBoardDelete")){
			action = new NotiBoardDeleteAction();
		} else if (command.equals("NotiBoardModify")){
			action = new NotiBoardModifyView();
		} else if (command.equals("NotiBoardAddAction")){
			action  = new NotiBoardAddAction();
		} else if (command.equals("NotiBoardModifyAction")){
			action = new NotiBoardModifyAction();
		} else if (command.equals("NotiBoardDeleteAction")){
			action = new NotiBoardDeleteAction();
		} else if (command.equals("NotiBoardList")){
			action = new NotiBoardListAction();
		} else if (command.equals("NotiBoardDetailAction")){
			action = new NotiBoardDetailAction();
		} else if (command.equals("piechart")){
			action = new PieChartAction();
		} else if (command.equals("deleteTeam")){
			action = new DeleteTeamAction();
		} else if (command.equals("recBoardCreate")) {
			action = new recBoardCreateAction();
		} else if (command.equals("updateReccount")) {
			action = new updateReccountAction();
		} else if (command.equals("updateReplycount")) {
			action = new updateReplycountAction();
		} else if (command.equals("bestBoardByReccount")) {
			action = new bestBoardByReccountAction();
		} else if (command.equals("bestBoardByreadcount")) {
			action = new bestBoardByreadcountAction();
		} else if (command.equals("boardRemove")) {
			action = new boardRemoveAction();
		} else if (command.equals("boardSearchByWriter")) {
			action = new boardSearchByWriterAction();
		} else if (command.equals("boardSearchBySubject")) {
			action = new boardSearchBySubjectAction();
		} else if (command.equals("boardModify")) {
			action = new boardModifyAction();
		} else if (command.equals("updateTeamNofp")) {
			action = new UpdateTeamNofpAction();
		} else if (command.equals("messageCreate")) {
			action = new messageCreateAction();
		} else if (command.equals("retrieveMessageList")) {
			action = new retrieveMessageListAction();
		} else if (command.equals("view_info")){
			action = new MemberInfoAction();
		}else if (command.equals("RetrieveMessage")) {
			action = new retrieveMessageAction();
		}
		else {
			throw new IllegalCommandException("�߸��� �������Դϴ�. �ٸ� ����� ������ �ֽʽÿ�");
		}

		return action;
	}
}
