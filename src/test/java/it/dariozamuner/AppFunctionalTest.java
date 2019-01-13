package it.dariozamuner;


import org.junit.jupiter.api.Test;


class AppFunctionalTest {

    @Test
    void mainOk() {
        App.main(new String[]{"5p 17s 8d + 3p 4s 10d"});
        App.main(new String[]{"5p 17s 8d - 3p 4s 10d"});
        App.main(new String[]{"5p 17s 8d * 2"});
        App.main(new String[]{"5p 17s 8d / 3"});
    }
}
