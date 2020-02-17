package com.wangrui.location.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;

import com.wangrui.location.entity.Student;
//https://github.com/sunjava2006/1904
@Mapper
public interface StudentMapper {
	
	@Select("select * from students where student_id=#{studentID} and passwd=#{passwd}")
	@Results(id = "StudentMapper",
			value = { @Result(column = "id", property = "id", id = true),
			          @Result(column = "name", property = "name"),
			          @Result(column = "passwd", property = "password"),
			          @Result(column = "gender", property = "gender"),
//			          @Result(column = "class_id", property = "classID"),
			          @Result(column = "student_id", property = "studentID"),
			          @Result(column = "class_id", property = "myClass",
			          one = @One(fetchType = FetchType.EAGER,
			        		  select = "com.wangrui.location.mapper.ClassMapper.findByID" ))
	        })
	public Student selectByIdAndPasswd(String studentID, String passwd);
	
	@Insert("insert into students(id,name,passwd,gender,class_id,student_id) "
			+ "values (seq_students.nextval,#{name},#{password},#{gender},#{classID},#{studentID})")
	public int insert(Student student);
	
	/**
	 * 完全以参数为准，更新数据库对象。如果参数中某个字段值为null，这个值也将会被更新到数据库对应的记录中。
	 * @param student
	 * @return
	 */
	@Update("update students set name=#{name},passwd=#{password},gender=#{gender},class_id=#{myClass.ID}"
			+ " where student_id=#{studentID}")
	public int updateAllProperties(Student student);
	
	@Delete("delete from students where student_id=#{studentID}")
	public int delete(String studentID);
	
	
	/**
	 * 以student对象中的studentID为条件，仅更新student对象中不为null的字段。
	 * @param student
	 * @return
	 */
	@UpdateProvider(type = StudentSQLProvider.class, method = "updateByExample")
	public int update(Student student);
}
