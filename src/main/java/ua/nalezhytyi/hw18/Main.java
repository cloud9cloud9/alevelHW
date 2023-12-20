package ua.nalezhytyi.hw18;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User();
//        user.setUserName("killer22");
//        user.setEmail("killer@gmail.com");
//        create(user);
//        User thatUser = readUser(3);
//        System.out.println(thatUser);
//        updateUser(3, "username", "kaktus1488");
//        deleteUserById(2);

        Order order = new Order();
        // readUserData(3L);

        List<User> usersWithMoreThanFiveOrders = getUsersWithMoreThanFiveOrders();
        writeListUsersAndOrder(usersWithMoreThanFiveOrders);

        List<Order> orderList = getOrdersByUserAndDateRange(3L,LocalDateTime.of(2024, 1, 28, 0, 0)
                , LocalDateTime.of(2024, 2, 1, 0, 0));
        writeListUsersAndOrder(orderList);


        List<Object[]> resultsObjectListWithSummaryOrder = getTotalOrdersOfUsers();
        for (Object[] result : resultsObjectListWithSummaryOrder) {
            Long userId = (Long) result[0];
            String userName = (String) result[1];
            Long totalOrders = (Long) result[2];

            System.out.println("User ID: " + userId + ", User Name: " + userName + ", Total Orders: " + totalOrders);
        }

    }
    private static <T> void writeListUsersAndOrder(List<T> data) {
        for (T element : data) {
            System.out.println("Element: " + element);
        }
    }

    private static EntityManager getConnection() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyUser");
        return emf.createEntityManager();
    }


    public static void create(Object obj) {
        try (EntityManager em = getConnection()) {
            em.getTransaction().begin();

            em.persist(obj);

            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static User readUser(long id) {
        try (EntityManager em = getConnection()) {

            return em.find(User.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void updateUser(long id, String nameColumn, String newName) {
        try (EntityManager em = getConnection()) {

            em.getTransaction().begin();

            User user = em.find(User.class, id);
            if (nameColumn.equals("username")) {
                user.setUserName(newName);
            } else {
                user.setEmail(newName);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteUserById(int userId) {
        try (EntityManager em = getConnection()) {
            em.getTransaction().begin();
            User user = em.find(User.class, userId);

            em.remove(user);

            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void readUserData(long userId) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyUser")) {
            EntityManager em = emf.createEntityManager();

            User user = em.find(User.class, userId);

            if (user != null) {
                System.out.println("User: " + user);

                List<Order> orders = user.getOrderList();
                if (orders != null && !((List<?>) orders).isEmpty()) {
                    System.out.println("Orders:");
                    for (Order order : orders) {
                        System.out.println("\t" + order);
                    }
                } else {
                    System.out.println("User has no orders.");
                }
            } else {
                System.out.println("User not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<User> getUsersWithMoreThanFiveOrders() {
        try (EntityManager em = getConnection()) {
            em.getTransaction().begin();
            String hql = "SELECT u FROM User u JOIN FETCH u.orderList o WHERE u.id IN (SELECT u.id FROM User u JOIN u.orderList o GROUP BY u.id HAVING COUNT(o) > 5)";
            Query query = em.createQuery(hql);
            List<User> result = query.getResultList();
            em.getTransaction().commit();
            return result;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static List<Order> getOrdersByUserAndDateRange(long userId, LocalDateTime startDate, LocalDateTime endDate) {
        try (EntityManager em = getConnection()) {
            em.getTransaction().begin();

            String hql = "SELECT o FROM Order o " +
                    "JOIN FETCH o.user u " +
                    "WHERE u.id = :userId " +
                    "AND o.createdAt BETWEEN :startDate AND :endDate";

            Query query = em.createQuery(hql)
                    .setParameter("userId", userId)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate);

            List<Order> orders = query.getResultList();

            em.getTransaction().commit();
            return orders;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Object[]> getTotalOrdersOfUsers() {
        try (EntityManager em = getConnection()) {
            em.getTransaction().begin();

            String hql = "SELECT u.id, u.userName, COUNT(o.id) " +
                    "FROM User u " +
                    "LEFT JOIN u.orderList o " +
                    "GROUP BY u.id, u.userName";

            Query query = em.createQuery(hql);
            List<Object[]> results = query.getResultList();

            em.getTransaction().commit();
            return results;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

