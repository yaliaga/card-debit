package pe.com.carddebit.model;


import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("cardYunki")
public class CardDebit implements Serializable {
	
	private static final long serialVersionUID = 5066137195411682542L;
	@Id
	private String id;
	private String type;
	private String numberCard;
	private String keyATM;
	private String keyInternet;
	private Date dueDate;
	private String idAccount;

}
