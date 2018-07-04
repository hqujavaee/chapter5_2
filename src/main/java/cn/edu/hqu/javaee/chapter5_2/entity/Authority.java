package cn.edu.hqu.javaee.chapter5_2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Authority implements GrantedAuthority {
    private static final long serialVersionUID = 1L;
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    @Getter
    @Setter
    private Long id; // 用户的唯一标识
    
    @Column(nullable = false) // 映射为字段，值不能为空
    @Getter
    @Setter
    private String name;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}

}
