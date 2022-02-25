// package tech.makers.tahut.model;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// @Entity
// @Table(name = "GROUPS_USERS")
// public class GroupsUsers {
//   @Id
//   @Column(name="groupid")
//   @GeneratedValue(strategy = GenerationType.AUTO)
//   private Long groupid;

//   @Column(name="userid")
//   private Long userid;
  
//   @ManyToMany(cascade = CascadeType.All)
//   @JoinTable()
// }
