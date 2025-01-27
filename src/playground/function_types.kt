package playground

class method_type {

    private var _fieldA = 0;

    fun printA() {
        println("A = $_fieldA");
    }

    fun setA(value: Int) {
        _fieldA = value;
    }
}

class function_types {

    val inputEvents = mutableListOf<(String, Int) -> Unit>();

    val classMethodEvents = mutableListOf<(Int) -> Unit>();
    val classMethodPrintEvents = mutableListOf<() -> Unit>();

    fun runBasicTest() {
        val keyLogger = { key: String, value: Int ->
            println("key: $key, value: $value");
        };

        val keyLogger2 = { key: String, value: Int ->
            println("key2: $key, value2: $value");
        }

        inputEvents.add(keyLogger);
        inputEvents.add(keyLogger2);

        inputEvents.forEach({ event ->
            event("k", 42);
            event("j", 69);
        });

        println("\n\n====================================\n\n");

        inputEvents.remove(keyLogger2);

        inputEvents.forEach({ event ->
            event("d", 2);
            event("e", 3);
        });
    }

    fun runClassMethodTest() {

        val classInstance1 = method_type();
        val classInstance2 = method_type();

        classMethodEvents.add(classInstance1::setA);
        classMethodEvents.add(classInstance2::setA);

        classMethodPrintEvents.add(classInstance1::printA);
        classMethodPrintEvents.add(classInstance2::printA);

        classMethodEvents.forEach({ event -> event(42) });

        classMethodPrintEvents.forEach({ e -> e() });

        println("\n\n====================================\n\n");

        classMethodEvents.remove(classInstance1::setA);

        classMethodEvents.forEach({ event -> event(69) });

        classMethodPrintEvents.forEach({ e -> e() });

        println("");

        println("classMethodEvents.size = ${classMethodEvents.size}");

        println("classMethodPrintEvents.size = ${classMethodPrintEvents.size}");
    }
}