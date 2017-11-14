package com.bysjglxt.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bysjglxt.dao.GraduationProjectManagementDao;
import com.bysjglxt.domain.DO.bysjglxt_defence;
import com.bysjglxt.domain.DO.bysjglxt_dissertation;
import com.bysjglxt.domain.DO.bysjglxt_evaluate_review;
import com.bysjglxt.domain.DO.bysjglxt_evaluate_tutor;
import com.bysjglxt.domain.DO.bysjglxt_examination_formal;
import com.bysjglxt.domain.DO.bysjglxt_leader;
import com.bysjglxt.domain.DO.bysjglxt_process_definition;
import com.bysjglxt.domain.DO.bysjglxt_process_instance;
import com.bysjglxt.domain.DO.bysjglxt_record_progress;
import com.bysjglxt.domain.DO.bysjglxt_report_opening;
import com.bysjglxt.domain.DO.bysjglxt_section;
import com.bysjglxt.domain.DO.bysjglxt_student_basic;
import com.bysjglxt.domain.DO.bysjglxt_student_user;
import com.bysjglxt.domain.DO.bysjglxt_summary;
import com.bysjglxt.domain.DO.bysjglxt_task_definition;
import com.bysjglxt.domain.DO.bysjglxt_task_instance;
import com.bysjglxt.domain.DO.bysjglxt_taskbook;
import com.bysjglxt.domain.DO.bysjglxt_teacher_basic;
import com.bysjglxt.domain.DO.bysjglxt_teacher_user;
import com.bysjglxt.domain.DO.bysjglxt_topic;
import com.bysjglxt.domain.DO.bysjglxt_topic_select;
import com.bysjglxt.domain.VO.TeacherTutorStudentVO;

public class GraduationProjectManagementDaoImpl implements GraduationProjectManagementDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public int fillEmptyInTaskBook(bysjglxt_taskbook bysjglxt_taskbook) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_taskbook);
		} catch (Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int fillEmptyInOpening(bysjglxt_report_opening bysjglxt_report_opening) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_report_opening);
		} catch (Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int fillEmptyInProgressEarlystage(bysjglxt_record_progress bysjglxt_record_progressEarlystage) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_record_progressEarlystage);
		} catch (Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int fillEmptyInSummary(bysjglxt_summary bysjglxt_summary) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_summary);
		} catch (Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int fillEmptyInExaminationFormal(bysjglxt_examination_formal bysjglxt_examination_formal) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_examination_formal);
		} catch (Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int fillEmptyInEvaluateTutor(bysjglxt_evaluate_tutor bysjglxt_evaluate_tutor) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_evaluate_tutor);
		} catch (Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int fillEmptyEvaluateReview(bysjglxt_evaluate_review bysjglxt_evaluate_review) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_evaluate_review);
		} catch (Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int fillEmptyDefence(bysjglxt_defence bysjglxt_defence) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_defence);
		} catch (Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public bysjglxt_taskbook getTaskbookById(String taskbook_id) {
		bysjglxt_taskbook bysjglxt_taskbook = new bysjglxt_taskbook();
		Session session = getSession();
		String hql = "from bysjglxt_taskbook where taskbook_id = '" + taskbook_id + "'";
		Query query = session.createQuery(hql);
		bysjglxt_taskbook = (bysjglxt_taskbook) query.uniqueResult();
		return bysjglxt_taskbook;
	}

	@Override
	public bysjglxt_report_opening getReportOpening(String report_opening_id) {
		bysjglxt_report_opening bysjglxt_report_opening = new bysjglxt_report_opening();
		Session session = getSession();
		String hql = "from bysjglxt_report_opening where report_opening_id = '" + report_opening_id + "'";
		Query query = session.createQuery(hql);
		bysjglxt_report_opening = (bysjglxt_report_opening) query.uniqueResult();
		return bysjglxt_report_opening;
	}

	@Override
	public bysjglxt_record_progress getRecordProgress(String record_progress_id) {
		bysjglxt_record_progress bysjglxt_record_progress = new bysjglxt_record_progress();
		Session session = getSession();
		String hql = "from bysjglxt_record_progress where report_opening_id = '" + record_progress_id + "'";
		Query query = session.createQuery(hql);
		bysjglxt_record_progress = (bysjglxt_record_progress) query.uniqueResult();
		return bysjglxt_record_progress;
	}

	@Override
	public bysjglxt_record_progress findRecordProgressByuserIdAndStage(String report_opening_student, String string) {
		bysjglxt_record_progress bysjglxt_record_progress = new bysjglxt_record_progress();
		Session session = getSession();
		String hql = "from bysjglxt_record_progress where record_progress _student='" + report_opening_student
				+ "' and record_progress _stage='" + string + "'";
		Query query = session.createQuery(hql);
		bysjglxt_record_progress = (bysjglxt_record_progress) query.uniqueResult();
		return bysjglxt_record_progress;
	}

	@Override
	public bysjglxt_summary findSummaryByUserId(String record_progress_id) {
		bysjglxt_summary bysjglxt_summary = new bysjglxt_summary();
		Session session = getSession();
		String hql = "from bysjglxt_summary where summary_student = '" + record_progress_id + "'";
		Query query = session.createQuery(hql);
		bysjglxt_summary = (bysjglxt_summary) query.uniqueResult();
		return bysjglxt_summary;
	}

	@Override
	public bysjglxt_summary findSummaryById(String summary_id) {
		bysjglxt_summary bysjglxt_summary = new bysjglxt_summary();
		Session session = getSession();
		String hql = "from bysjglxt_summary where summary_id = '" + summary_id + "'";
		Query query = session.createQuery(hql);
		bysjglxt_summary = (bysjglxt_summary) query.uniqueResult();
		return bysjglxt_summary;
	}

	@Override
	public bysjglxt_examination_formal findExaminationFormalById(String examination_formal_id) {
		bysjglxt_examination_formal bysjglxt_examination_formal = new bysjglxt_examination_formal();
		Session session = getSession();
		String hql = "from bysjglxt_examination_formal where examination_formal_id = '" + examination_formal_id + "'";
		Query query = session.createQuery(hql);
		bysjglxt_examination_formal = (bysjglxt_examination_formal) query.uniqueResult();
		return bysjglxt_examination_formal;
	}

	@Override
	public bysjglxt_evaluate_tutor findEvaluateTutor(String evaluate_tutor_id) {
		bysjglxt_evaluate_tutor bysjglxt_evaluate_tutor = new bysjglxt_evaluate_tutor();
		Session session = getSession();
		String hql = "from bysjglxt_evaluate_tutor where evaluate_tutor_id = '" + evaluate_tutor_id + "'";
		Query query = session.createQuery(hql);
		bysjglxt_evaluate_tutor = (bysjglxt_evaluate_tutor) query.uniqueResult();
		return bysjglxt_evaluate_tutor;
	}

	@Override
	public bysjglxt_evaluate_review findEvaluateReviewById(String evaluate_review_id) {
		bysjglxt_evaluate_review bysjglxt_evaluate_review = new bysjglxt_evaluate_review();
		Session session = getSession();
		String hql = "from bysjglxt_evaluate_review where evaluate_review_id = '" + evaluate_review_id + "'";
		Query query = session.createQuery(hql);
		bysjglxt_evaluate_review = (bysjglxt_evaluate_review) query.uniqueResult();
		return bysjglxt_evaluate_review;
	}

	@Override
	public bysjglxt_defence findDefenceById(String defence_id) {
		bysjglxt_defence bysjglxt_defence = new bysjglxt_defence();
		Session session = getSession();
		String hql = "from bysjglxt_defence where defence_id = '" + defence_id + "'";
		Query query = session.createQuery(hql);
		bysjglxt_defence = (bysjglxt_defence) query.uniqueResult();
		return bysjglxt_defence;
	}

	@Override
	public bysjglxt_defence findDefenceByUserId(String evaluate_tutor_student) {
		bysjglxt_defence bysjglxt_defence = new bysjglxt_defence();
		Session session = getSession();
		String hql = "from bysjglxt_defence where defence_student = '" + evaluate_tutor_student + "'";
		Query query = session.createQuery(hql);
		bysjglxt_defence = (bysjglxt_defence) query.uniqueResult();
		return bysjglxt_defence;
	}

	/*********************************************************************************/
	// 获得任务书
	@Override
	public bysjglxt_taskbook getTaskBookByUserId(String userId) {
		bysjglxt_taskbook bysjglxt_taskbook = new bysjglxt_taskbook();
		Session session = getSession();
		String hql = "from bysjglxt_taskbook where bysjglxt_taskbook_student = '" + userId + "'";
		Query query = session.createQuery(hql);
		bysjglxt_taskbook = (bysjglxt_taskbook) query.uniqueResult();
		return bysjglxt_taskbook;
	}

	// 获得开题报告
	@Override
	public bysjglxt_report_opening getReportOpeningUser(String userId) {
		bysjglxt_report_opening bysjglxt_report_opening = new bysjglxt_report_opening();
		Session session = getSession();
		String hql = "from bysjglxt_report_opening where report_opening_student = '" + userId + "'";
		Query query = session.createQuery(hql);
		bysjglxt_report_opening = (bysjglxt_report_opening) query.uniqueResult();
		return bysjglxt_report_opening;
	}

	@Override
	public bysjglxt_record_progress getRecordProgress(String userId, String string) {
		bysjglxt_record_progress bysjglxt_record_progress = new bysjglxt_record_progress();
		Session session = getSession();
		String hql = "from bysjglxt_record_progress where record_progress_student = '" + userId
				+ "' and record_progress_stage = '" + string + "'";
		Query query = session.createQuery(hql);
		bysjglxt_record_progress = (bysjglxt_record_progress) query.uniqueResult();
		return bysjglxt_record_progress;
	}

	@Override
	public bysjglxt_summary getSummary(String userId) {
		bysjglxt_summary bysjglxt_summary = new bysjglxt_summary();
		Session session = getSession();
		String hql = "from bysjglxt_summary where summary_student = '" + userId + "'";
		Query query = session.createQuery(hql);
		bysjglxt_summary = (bysjglxt_summary) query.uniqueResult();
		return bysjglxt_summary;
	}

	@Override
	public bysjglxt_examination_formal getExaminationFormal(String userId) {
		bysjglxt_examination_formal bysjglxt_examination_formal = new bysjglxt_examination_formal();
		Session session = getSession();
		String hql = "from bysjglxt_examination_formal where examination_formal_student = '" + userId + "'";
		Query query = session.createQuery(hql);
		bysjglxt_examination_formal = (bysjglxt_examination_formal) query.uniqueResult();
		return bysjglxt_examination_formal;
	}

	@Override
	public bysjglxt_evaluate_tutor getEvaluateTutor(String userId) {
		bysjglxt_evaluate_tutor bysjglxt_evaluate_tutor = new bysjglxt_evaluate_tutor();
		Session session = getSession();
		String hql = "from bysjglxt_evaluate_tutor where evaluate_tutor_student = '" + userId + "'";
		Query query = session.createQuery(hql);
		bysjglxt_evaluate_tutor = (bysjglxt_evaluate_tutor) query.uniqueResult();
		return bysjglxt_evaluate_tutor;
	}

	@Override
	public bysjglxt_evaluate_review getEvaluateReview(String userId) {
		bysjglxt_evaluate_review bysjglxt_evaluate_review = new bysjglxt_evaluate_review();
		Session session = getSession();
		String hql = "from bysjglxt_evaluate_review where evaluate_review_student = '" + userId + "'";
		Query query = session.createQuery(hql);
		bysjglxt_evaluate_review = (bysjglxt_evaluate_review) query.uniqueResult();
		return bysjglxt_evaluate_review;
	}

	@Override
	public bysjglxt_defence getDefence(String userId) {
		bysjglxt_defence bysjglxt_defence = new bysjglxt_defence();
		Session session = getSession();
		String hql = "from bysjglxt_defence where defence_student = '" + userId + "'";
		Query query = session.createQuery(hql);
		bysjglxt_defence = (bysjglxt_defence) query.uniqueResult();
		return bysjglxt_defence;
	}

	/************************************ 导出 ******************************************/

	// 根据userid获取user表中信息
	@Override
	public bysjglxt_student_user getStudentUserByUserId(String studentUserId) {
		bysjglxt_student_user bysjglxt_student_user = new bysjglxt_student_user();
		Session session = getSession();
		String hql = "from bysjglxt_student_user where user_student_id = '" + studentUserId + "'";
		Query query = session.createQuery(hql);
		bysjglxt_student_user = (bysjglxt_student_user) query.uniqueResult();
		return bysjglxt_student_user;
	}

	// 根据basicId获取学生basic表中信息
	@Override
	public bysjglxt_student_basic getStudentBasicByBasicId(String user_student_basic) {
		bysjglxt_student_basic bysjglxt_student_basic = new bysjglxt_student_basic();
		Session session = getSession();
		String hql = "from bysjglxt_student_basic where student_basic_id = '" + user_student_basic + "'";
		Query query = session.createQuery(hql);
		bysjglxt_student_basic = (bysjglxt_student_basic) query.uniqueResult();
		return bysjglxt_student_basic;
	}

	// 根据userId获取选题表中的信息
	@Override
	public bysjglxt_topic_select getStudentSelectTopic(String user_student_id) {
		bysjglxt_topic_select bysjglxt_topic_select = new bysjglxt_topic_select();
		Session session = getSession();
		String hql = "from bysjglxt_topic_select where topic_select_student = '" + user_student_id + "'";
		Query query = session.createQuery(hql);
		bysjglxt_topic_select = (bysjglxt_topic_select) query.uniqueResult();
		return bysjglxt_topic_select;
	}

	// 根据教师userId获取教师user表信息
	@Override
	public bysjglxt_teacher_user getTeacherUserByUserId(String topic_select_teacher_tutor) {
		bysjglxt_teacher_user bysjglxt_teacher_user = new bysjglxt_teacher_user();
		Session session = getSession();
		String hql = "from bysjglxt_teacher_user where user_teacher_id = '" + topic_select_teacher_tutor + "'";
		Query query = session.createQuery(hql);
		bysjglxt_teacher_user = (bysjglxt_teacher_user) query.uniqueResult();
		return bysjglxt_teacher_user;
	}

	// 根据教师basicId获取教师basic表信息
	@Override
	public bysjglxt_teacher_basic getTeacherBasicByBasicId(String user_teacher_basic) {
		bysjglxt_teacher_basic bysjglxt_teacher_basic = new bysjglxt_teacher_basic();
		Session session = getSession();
		String hql = "from bysjglxt_teacher_basic where teacher_basic_id = '" + user_teacher_basic + "'";
		Query query = session.createQuery(hql);
		bysjglxt_teacher_basic = (bysjglxt_teacher_basic) query.uniqueResult();
		return bysjglxt_teacher_basic;
	}

	// 根据课题ID获取课题信息
	@Override
	public bysjglxt_topic getStudentTopicByTopicId(String topic_select_topic) {
		bysjglxt_topic bysjglxt_topic = new bysjglxt_topic();
		Session session = getSession();
		String hql = "from bysjglxt_topic where topic_id = '" + topic_select_topic + "'";
		Query query = session.createQuery(hql);
		bysjglxt_topic = (bysjglxt_topic) query.uniqueResult();
		return bysjglxt_topic;
	}

	// 根据指导老师ID获得分页显示的学生选题
	@Override
	public List<bysjglxt_topic_select> getTeacherTutorStudentSelectTopicByPage(
			TeacherTutorStudentVO teacherTutorStudentVO, String teacherUserId, String actor, String section) {
		Session session = getSession();
		List<bysjglxt_topic_select> listBysjglxtTopicSelect = new ArrayList<bysjglxt_topic_select>();
		String hql = "";
		switch (actor) {
		case "无":
			return listBysjglxtTopicSelect;
		case "领导小组长":
			switch (teacherTutorStudentVO.getState()) {
			case -1:
				// 不进行状态筛选
				hql = "select topicSelect from bysjglxt_topic_select topicSelect where 1=1 ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 1:
				hql = "select topicSelect from bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance ";
				hql = hql + "where topicSelect.topic_select_topic = topic.topic_id and"
						+ "  processInstance.process_instance_man = topicSelect.topic_select_student "
						+ " and process_instance_state='活动' ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 2:
				hql = "select topicSelect from bysjglxt_topic_select topicSelect,bysjglxt_topic topic"
						+ " where topicSelect.topic_select_topic = topic.topic_id ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + " and topicSelect.topic_select_id not in(select topicSelect.topic_select_id from "
						+ "bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance";
				hql = hql
						+ " where topicSelect.topic_select_topic = topic.topic_id and processInstance.process_instance_man = topicSelect.topic_select_student)";
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 3:
				hql = "select topicSelect from bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance ";
				hql = hql + "where topicSelect.topic_select_topic = topic.topic_id and"
						+ "  processInstance.process_instance_man = topicSelect.topic_select_student "
						+ " and process_instance_state='结束' ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			}
			break;
		case "教研室主任":
			switch (teacherTutorStudentVO.getState()) {
			case -1:
				// 不进行状态筛选
				hql = "select topicSelect from bysjglxt_topic_select topicSelect,bysjglxt_student_user studentUser,bysjglxt_student_basic studentBasic "
						+ "where topicSelect.topic_select_student=studentUser.user_student_id and studentUser.user_student_basic=studentBasic.student_basic_id ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				switch (section) {
				case "软件工程教研室":
					hql = hql + " and (studentBasic.student_basic_major = '软件工程')";
					break;
				case "数媒教研室":
					hql = hql + " and (studentBasic.student_basic_major = '数媒')";
					break;
				}
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 1:
				hql = "select topicSelect from bysjglxt_student_user studentUser,bysjglxt_student_basic studentBasic,bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance ";
				hql = hql + "where topicSelect.topic_select_topic = topic.topic_id and"
						+ "  processInstance.process_instance_man = topicSelect.topic_select_student "
						+ " and process_instance_state='活动' ";
				hql = hql
						+ " and topicSelect.topic_select_student=studentUser.user_student_id and studentUser.user_student_basic=studentBasic.student_basic_id";
				switch (section) {
				case "软件工程教研室":
					hql = hql + " and (studentBasic.student_basic_major = '软件工程')";
					break;
				case "数媒教研室":
					hql = hql + " and (studentBasic.student_basic_major = '数媒')";
					break;
				}
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 2:
				hql = "select topicSelect from bysjglxt_student_user studentUser,bysjglxt_student_basic studentBasic,bysjglxt_topic_select topicSelect,bysjglxt_topic topic"
						+ " where topicSelect.topic_select_topic = topic.topic_id  and topicSelect.topic_select_student=studentUser.user_student_id and studentUser.user_student_basic=studentBasic.student_basic_id";
				switch (section) {
				case "软件工程教研室":
					hql = hql + " and (studentBasic.student_basic_major = '软件工程')";
					break;
				case "数媒教研室":
					hql = hql + " and (studentBasic.student_basic_major = '数媒')";
					break;
				}
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + " and topicSelect.topic_select_id not in(select topicSelect.topic_select_id from "
						+ "bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance";
				hql = hql
						+ " where topicSelect.topic_select_topic = topic.topic_id and processInstance.process_instance_man = topicSelect.topic_select_student)";
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 3:
				hql = "select topicSelect from bysjglxt_student_user studentUser,bysjglxt_student_basic studentBasic,bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance ";
				hql = hql + "where topicSelect.topic_select_topic = topic.topic_id and"
						+ "  processInstance.process_instance_man = topicSelect.topic_select_student "
						+ " and process_instance_state='结束' ";
				switch (section) {
				case "软件工程教研室":
					hql = hql + " and (studentBasic.student_basic_major = '软件工程')";
					break;
				case "数媒教研室":
					hql = hql + " and (studentBasic.student_basic_major = '数媒')";
					break;
				}
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			}
			break;
		case "指导老师":
			switch (teacherTutorStudentVO.getState()) {
			case -1:
				// 不进行状态筛选
				hql = "select topicSelect from bysjglxt_topic_select topicSelect where 1=1 ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + " and topicSelect.topic_select_teacher_tutor='" + teacherUserId + "'";
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 1:
				hql = "select topicSelect from bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance ";
				hql = hql + "where topicSelect.topic_select_topic = topic.topic_id and"
						+ "  processInstance.process_instance_man = topicSelect.topic_select_student "
						+ " and process_instance_state='活动' ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + " and topicSelect.topic_select_teacher_tutor='" + teacherUserId + "'";
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 2:
				hql = "select topicSelect from bysjglxt_topic_select topicSelect,bysjglxt_topic topic"
						+ " where topicSelect.topic_select_topic = topic.topic_id ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + " and topicSelect.topic_select_teacher_tutor='" + teacherUserId + "'";
				hql = hql + " and topicSelect.topic_select_id not in(select topicSelect.topic_select_id from "
						+ "bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance";
				hql = hql
						+ " where topicSelect.topic_select_topic = topic.topic_id and processInstance.process_instance_man = topicSelect.topic_select_student)";
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 3:
				hql = "select topicSelect from bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance ";
				hql = hql + "where topicSelect.topic_select_topic = topic.topic_id and"
						+ "  processInstance.process_instance_man = topicSelect.topic_select_student "
						+ " and process_instance_state='结束' ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + " and topicSelect.topic_select_teacher_tutor='" + teacherUserId + "'";
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			}
			hql = "from bysjglxt_topic_select where topic_select_teacher_tutor='" + teacherUserId
					+ "' order by topic_select_gmt_create";
			break;
		}
		System.out.println(hql);
		Query query = session.createQuery(hql);
		query.setFirstResult((teacherTutorStudentVO.getPageIndex() - 1) * teacherTutorStudentVO.getPageSize());
		query.setMaxResults(teacherTutorStudentVO.getPageSize());
		listBysjglxtTopicSelect = query.list();
		session.clear();
		return listBysjglxtTopicSelect;
	}

	// 根据Man获取这个用户的所有实例化者流程实例
	@Override
	public List<bysjglxt_process_instance> getProcessInstanceByMan(String topic_select_student) {
		List<bysjglxt_process_instance> list_bysjglxt_process_instance = new ArrayList<bysjglxt_process_instance>();
		Session session = getSession();
		String hql = "from bysjglxt_process_instance where process_instance_man = '" + topic_select_student + "'";
		Query query = session.createQuery(hql);
		list_bysjglxt_process_instance = query.list();
		return list_bysjglxt_process_instance;
	}

	// 根据流程定义ID获取流程记录
	@Override
	public bysjglxt_process_definition getProcessDefinitionByID(String process_instance_process_definition) {
		bysjglxt_process_definition bysjglxt_process_definition = new bysjglxt_process_definition();
		Session session = getSession();
		String hql = "from bysjglxt_process_definition where process_definition_id = '"
				+ process_instance_process_definition + "'";
		Query query = session.createQuery(hql);
		bysjglxt_process_definition = (bysjglxt_process_definition) query.uniqueResult();
		return bysjglxt_process_definition;
	}

	// 根据流程实例ID以及任务实例状态获取任务实例
	@Override
	public bysjglxt_task_instance getTaskInstanceByProcessInstanceId(String process_instance_id) {
		bysjglxt_task_instance bysjglxt_task_instance = new bysjglxt_task_instance();
		Session session = getSession();
		String hql = "from bysjglxt_task_instance where task_instance_process_instance = '" + process_instance_id
				+ "' and task_instance_state=1";
		Query query = session.createQuery(hql);
		bysjglxt_task_instance = (bysjglxt_task_instance) query.uniqueResult();
		return bysjglxt_task_instance;
	}

	// 根据任务定义Id获取任务定义记录
	@Override
	public bysjglxt_task_definition getTaskDefinition(String task_instance_task_definition) {
		bysjglxt_task_definition bysjglxt_task_definition = new bysjglxt_task_definition();
		Session session = getSession();
		String hql = "from bysjglxt_task_definition where task_definition_id = '" + task_instance_task_definition + "'";
		Query query = session.createQuery(hql);
		bysjglxt_task_definition = (bysjglxt_task_definition) query.uniqueResult();
		return bysjglxt_task_definition;
	}
	// 获取总记录数
	@Override
	public List<bysjglxt_topic_select> getTeacherTutorStudentAllSelectTopic(TeacherTutorStudentVO teacherTutorStudentVO,
			String teacherUserId, String actor, String section) {
		Session session = getSession();
		List<bysjglxt_topic_select> listBysjglxtTopicSelect = new ArrayList<bysjglxt_topic_select>();
		String hql = "";
		switch (actor) {
		case "无":
			return listBysjglxtTopicSelect;
		case "领导小组长":
			switch (teacherTutorStudentVO.getState()) {
			case -1:
				// 不进行状态筛选
				hql = "select topicSelect from bysjglxt_topic_select topicSelect where 1=1 ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 1:
				hql = "select topicSelect from bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance ";
				hql = hql + "where topicSelect.topic_select_topic = topic.topic_id and"
						+ "  processInstance.process_instance_man = topicSelect.topic_select_student "
						+ " and process_instance_state='活动' ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 2:
				hql = "select topicSelect from bysjglxt_topic_select topicSelect,bysjglxt_topic topic"
						+ " where topicSelect.topic_select_topic = topic.topic_id ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + " and topicSelect.topic_select_id not in(select topicSelect.topic_select_id from "
						+ "bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance";
				hql = hql
						+ " where topicSelect.topic_select_topic = topic.topic_id and processInstance.process_instance_man = topicSelect.topic_select_student)";
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 3:
				hql = "select topicSelect from bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance ";
				hql = hql + "where topicSelect.topic_select_topic = topic.topic_id and"
						+ "  processInstance.process_instance_man = topicSelect.topic_select_student "
						+ " and process_instance_state='结束' ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			}
			break;
		case "教研室主任":
			switch (teacherTutorStudentVO.getState()) {
			case -1:
				// 不进行状态筛选
				hql = "select topicSelect from bysjglxt_topic_select topicSelect,bysjglxt_student_user studentUser,bysjglxt_student_basic studentBasic "
						+ "where topicSelect.topic_select_student=studentUser.user_student_id and studentUser.user_student_basic=studentBasic.student_basic_id ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				switch (section) {
				case "软件工程教研室":
					hql = hql + " and (studentBasic.student_basic_major = '软件工程')";
					break;
				case "数媒教研室":
					hql = hql + " and (studentBasic.student_basic_major = '数媒')";
					break;
				}
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 1:
				hql = "select topicSelect from bysjglxt_student_user studentUser,bysjglxt_student_basic studentBasic,bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance ";
				hql = hql + "where topicSelect.topic_select_topic = topic.topic_id and"
						+ "  processInstance.process_instance_man = topicSelect.topic_select_student "
						+ " and process_instance_state='活动' ";
				hql = hql
						+ " and topicSelect.topic_select_student=studentUser.user_student_id and studentUser.user_student_basic=studentBasic.student_basic_id";
				switch (section) {
				case "软件工程教研室":
					hql = hql + " and (studentBasic.student_basic_major = '软件工程')";
					break;
				case "数媒教研室":
					hql = hql + " and (studentBasic.student_basic_major = '数媒')";
					break;
				}
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 2:
				hql = "select topicSelect from bysjglxt_student_user studentUser,bysjglxt_student_basic studentBasic,bysjglxt_topic_select topicSelect,bysjglxt_topic topic"
						+ " where topicSelect.topic_select_topic = topic.topic_id  and topicSelect.topic_select_student=studentUser.user_student_id and studentUser.user_student_basic=studentBasic.student_basic_id";
				switch (section) {
				case "软件工程教研室":
					hql = hql + " and (studentBasic.student_basic_major = '软件工程')";
					break;
				case "数媒教研室":
					hql = hql + " and (studentBasic.student_basic_major = '数媒')";
					break;
				}
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + " and topicSelect.topic_select_id not in(select topicSelect.topic_select_id from "
						+ "bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance";
				hql = hql
						+ " where topicSelect.topic_select_topic = topic.topic_id and processInstance.process_instance_man = topicSelect.topic_select_student)";
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 3:
				hql = "select topicSelect from bysjglxt_student_user studentUser,bysjglxt_student_basic studentBasic,bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance ";
				hql = hql + "where topicSelect.topic_select_topic = topic.topic_id and"
						+ "  processInstance.process_instance_man = topicSelect.topic_select_student "
						+ " and process_instance_state='结束' ";
				switch (section) {
				case "软件工程教研室":
					hql = hql + " and (studentBasic.student_basic_major = '软件工程')";
					break;
				case "数媒教研室":
					hql = hql + " and (studentBasic.student_basic_major = '数媒')";
					break;
				}
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			}
			break;
		case "指导老师":
			switch (teacherTutorStudentVO.getState()) {
			case -1:
				// 不进行状态筛选
				hql = "select topicSelect from bysjglxt_topic_select topicSelect where 1=1 ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + " and topicSelect.topic_select_teacher_tutor='" + teacherUserId + "'";
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 1:
				hql = "select topicSelect from bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance ";
				hql = hql + "where topicSelect.topic_select_topic = topic.topic_id and"
						+ "  processInstance.process_instance_man = topicSelect.topic_select_student "
						+ " and process_instance_state='活动' ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + " and topicSelect.topic_select_teacher_tutor='" + teacherUserId + "'";
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 2:
				hql = "select topicSelect from bysjglxt_topic_select topicSelect,bysjglxt_topic topic"
						+ " where topicSelect.topic_select_topic = topic.topic_id ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + " and topicSelect.topic_select_teacher_tutor='" + teacherUserId + "'";
				hql = hql + " and topicSelect.topic_select_id not in(select topicSelect.topic_select_id from "
						+ "bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance";
				hql = hql
						+ " where topicSelect.topic_select_topic = topic.topic_id and processInstance.process_instance_man = topicSelect.topic_select_student)";
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			case 3:
				hql = "select topicSelect from bysjglxt_topic_select topicSelect,bysjglxt_topic topic,bysjglxt_process_instance processInstance ";
				hql = hql + "where topicSelect.topic_select_topic = topic.topic_id and"
						+ "  processInstance.process_instance_man = topicSelect.topic_select_student "
						+ " and process_instance_state='结束' ";
				if (teacherTutorStudentVO.getSearch() != null
						&& teacherTutorStudentVO.getSearch().trim().length() > 0) {
					hql = hql + " and topic.topic_name_chinese like %'" + teacherTutorStudentVO.getSearch() + "'%";
				}
				hql = hql + " and topicSelect.topic_select_teacher_tutor='" + teacherUserId + "'";
				hql = hql + "order by topicSelect.topic_select_gmt_create";
				break;
			}
			hql = "from bysjglxt_topic_select where topic_select_teacher_tutor='" + teacherUserId
					+ "' order by topic_select_gmt_create";
			break;
		}
		Query query = session.createQuery(hql);
		listBysjglxtTopicSelect = query.list();
		session.clear();
		return listBysjglxtTopicSelect;
	}

	@Override
	public bysjglxt_leader getLeader(String teacherUserId) {
		bysjglxt_leader bysjglxt_leader = new bysjglxt_leader();
		Session session = getSession();
		String hql = "from bysjglxt_leader where leader_teacher_id = '" + teacherUserId + "'";
		Query query = session.createQuery(hql);
		bysjglxt_leader = (bysjglxt_leader) query.uniqueResult();
		return bysjglxt_leader;
	}

	@Override
	public bysjglxt_section getSectionByUserId(String teacherUserId) {
		bysjglxt_section bysjglxt_section = new bysjglxt_section();
		Session session = getSession();
		String hql = "from bysjglxt_section where section_leader = '" + teacherUserId + "'";
		Query query = session.createQuery(hql);
		bysjglxt_section = (bysjglxt_section) query.uniqueResult();
		return bysjglxt_section;
	}

	// 查找学生是否已经上传毕业论文
	@Override
	public bysjglxt_dissertation getThesisByStudent(String userId) {
		bysjglxt_dissertation bysjglxt_dissertation = new bysjglxt_dissertation();
		Session session = getSession();
		String hql = "from bysjglxt_dissertation where dissertation_student = '" + userId + "'";
		Query query = session.createQuery(hql);
		bysjglxt_dissertation = (bysjglxt_dissertation) query.uniqueResult();
		return bysjglxt_dissertation;
	}

	// 根据学生Id删除学生论文上传记录
	@Override
	public boolean deleteThesisByUserId(String userId) {
		boolean flag = true;
		try {
			Session session = getSession();
			String hql = "delete from bysjglxt_dissertation where dissertation_student='" + userId + "'";
			Query query = session.createQuery(hql);
			query.executeUpdate();
		} catch (HibernateException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean fillEmptyThesisRecord(bysjglxt_dissertation bysjglxt_dissertation) {
		boolean flag = true;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_dissertation);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<bysjglxt_topic_select> getSelectTopicByTutorId(String teacherUserId) {
		List<bysjglxt_topic_select> list_bysjglxt_topic_select = new ArrayList<bysjglxt_topic_select>();
		Session session = getSession();
		String hql = "from bysjglxt_topic_select where topic_select_teacher_tutor = '" + teacherUserId + "'";
		Query query = session.createQuery(hql);
		list_bysjglxt_topic_select = query.list();
		return list_bysjglxt_topic_select;
	}
}
