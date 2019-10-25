package org.gciatto.kt.math

import kotlin.test.Test
import kotlin.test.assertEquals

class TestDecimals {

    fun assertEquals(x: BigDecimal, y: BigDecimal, m: String? = "Failed: $x == $y") {
        if (m === null) {
            assertEquals(0, x.compareTo(y))
            assertEquals(0, y.compareTo(x))
        } else {
            assertEquals(0, x.compareTo(y), m)
            assertEquals(0, y.compareTo(x), m)
        }
    }

    fun assertReprEquals(repr: Any, obj: Any, m: String? = "Failed: $obj.toString() == $repr") {
        if (m === null) {
            assertEquals(repr.toString(), obj.toString())
        } else {
            assertEquals(repr.toString(), obj.toString(), m)
        }
    }

    @Test
    fun testCreation() {
        assertReprEquals("0", BigDecimal.ZERO)
        assertReprEquals("1", BigDecimal.ONE)
        assertReprEquals("2", BigDecimal.TWO)
        assertReprEquals("10", BigDecimal.TEN)
        assertReprEquals("0.5", BigDecimal.ONE_HALF)
        assertReprEquals("0.1", BigDecimal.ONE_TENTH)
        assertReprEquals("-1", -BigDecimal.ONE)
        assertReprEquals("-2", -BigDecimal.TWO)
        assertReprEquals("-10", -BigDecimal.TEN)
        assertReprEquals("-0.5", -BigDecimal.ONE_HALF)
        assertReprEquals("-0.1", -BigDecimal.ONE_TENTH)

        assertReprEquals("1.7976931348623157E+308", BigDecimal.of(Double.MAX_VALUE))
        assertReprEquals("4.9E-324", BigDecimal.of(Double.MIN_VALUE))
        assertReprEquals("3.4028234663852886E+38", BigDecimal.of(Float.MAX_VALUE))
        assertReprEquals("1.401298464324817E-45", BigDecimal.of(Float.MIN_VALUE))

        assertReprEquals("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648",
            BigDecimal.PI)

        assertReprEquals("2.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264",
            BigDecimal.E)

        assertEquals(BigDecimal.ZERO, BigDecimal.of(0))
        assertEquals(BigDecimal.ONE, BigDecimal.of(1))
        assertEquals(BigDecimal.TWO, BigDecimal.of(2))
        assertEquals(BigDecimal.TEN, BigDecimal.of(10))
        assertEquals(BigDecimal.ONE_HALF, BigDecimal.of(1) / BigDecimal.of(2))
        assertEquals(BigDecimal.ONE_TENTH, BigDecimal.of(1) / BigDecimal.of(10))
        assertEquals(-BigDecimal.ONE, BigDecimal.of(-1))
        assertEquals(-BigDecimal.TWO, BigDecimal.of(-2))
        assertEquals(-BigDecimal.TEN, BigDecimal.of(-10))
        assertEquals(-BigDecimal.ONE_HALF, BigDecimal.of(-1) / BigDecimal.of(2))
        assertEquals(-BigDecimal.ONE_TENTH, BigDecimal.of(-1) / BigDecimal.of(10))

        assertEquals(BigDecimal.ZERO, BigDecimal.of(0.0))
        assertEquals(BigDecimal.ONE, BigDecimal.of(1.0))
        assertEquals(BigDecimal.TWO, BigDecimal.of(2.0))
        assertEquals(BigDecimal.TEN, BigDecimal.of(10.0))
        assertEquals(BigDecimal.ONE_HALF, BigDecimal.of(0.5))
        assertEquals(BigDecimal.ONE_TENTH, BigDecimal.of(0.1))
        assertEquals(-BigDecimal.ONE, BigDecimal.of(-1.0))
        assertEquals(-BigDecimal.TWO, BigDecimal.of(-2.0))
        assertEquals(-BigDecimal.TEN, BigDecimal.of(-10.0))
        assertEquals(-BigDecimal.ONE_HALF, BigDecimal.of(-0.5))
        assertEquals(-BigDecimal.ONE_TENTH, BigDecimal.of(-0.1))
    }

    @Test
    fun testSum() {
        assertEquals(BigDecimal.of(-1 + 1), BigDecimal.of(-1) + BigDecimal.ONE)
        assertEquals(BigDecimal.of(0 + 1), BigDecimal.of(0) + BigDecimal.ONE)
        assertEquals(BigDecimal.of(1 + 1), BigDecimal.of(1) + BigDecimal.ONE)

        assertEquals(BigDecimal.of(-1 + 2), BigDecimal.of(-1) + BigDecimal.TWO)
        assertEquals(BigDecimal.of(0 + 2), BigDecimal.of(0) + BigDecimal.TWO)
        assertEquals(BigDecimal.of(1 + 2), BigDecimal.of(1) + BigDecimal.TWO)

        assertEquals(BigDecimal.of(-1 + 10), BigDecimal.of(-1) + BigDecimal.TEN)
        assertEquals(BigDecimal.of(0 + 10), BigDecimal.of(0) + BigDecimal.TEN)
        assertEquals(BigDecimal.of(1 + 10), BigDecimal.of(1) + BigDecimal.TEN)

        assertReprEquals("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648",
            BigDecimal.PI + BigDecimal.ZERO)
        assertReprEquals("4.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648",
            BigDecimal.PI + BigDecimal.ONE)
        assertReprEquals("5.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648",
            BigDecimal.PI + BigDecimal.TWO)
        assertReprEquals("13.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648",
            BigDecimal.PI + BigDecimal.TEN)
        assertReprEquals("3.641592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648",
            BigDecimal.PI + BigDecimal.ONE_HALF)
        assertReprEquals("3.241592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648",
            BigDecimal.PI + BigDecimal.ONE_TENTH)

        assertReprEquals("2.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264",
            BigDecimal.E + BigDecimal.ZERO)
        assertReprEquals("3.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264",
            BigDecimal.E + BigDecimal.ONE)
        assertReprEquals("4.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264",
            BigDecimal.E + BigDecimal.TWO)
        assertReprEquals("12.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264",
            BigDecimal.E + BigDecimal.TEN)
        assertReprEquals("3.218281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264",
            BigDecimal.E + BigDecimal.ONE_HALF)
        assertReprEquals("2.818281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264",
            BigDecimal.E + BigDecimal.ONE_TENTH)

        assertReprEquals("179769313486231570000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001",
            BigDecimal.of(Double.MAX_VALUE) + BigDecimal.ONE)
    }

    @Test
    fun testSub() {
        assertEquals(BigDecimal.of(-1 - 1), BigDecimal.of(-1) - BigDecimal.ONE)
        assertEquals(BigDecimal.of(0 - 1), BigDecimal.of(0) - BigDecimal.ONE)
        assertEquals(BigDecimal.of(1 - 1), BigDecimal.of(1) - BigDecimal.ONE)

        assertEquals(BigDecimal.of(-1 - 2), BigDecimal.of(-1) - BigDecimal.TWO)
        assertEquals(BigDecimal.of(0 - 2), BigDecimal.of(0) - BigDecimal.TWO)
        assertEquals(BigDecimal.of(1 - 2), BigDecimal.of(1) - BigDecimal.TWO)

        assertEquals(BigDecimal.of(-1 - 10), BigDecimal.of(-1) - BigDecimal.TEN)
        assertEquals(BigDecimal.of(0 - 10), BigDecimal.of(0) - BigDecimal.TEN)
        assertEquals(BigDecimal.of(1 - 10), BigDecimal.of(1) - BigDecimal.TEN)

        assertReprEquals("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648",
            BigDecimal.PI - BigDecimal.ZERO)
        assertReprEquals("2.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648",
            BigDecimal.PI - BigDecimal.ONE)
        assertReprEquals("1.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648",
            BigDecimal.PI - BigDecimal.TWO)
        assertReprEquals("-6.858407346410206761537356616720497115802830600624894179025055407692183593713791001371965174657882932017851913486717693352906155390449417768274640591871518882549715897298061478894440355377051045069618035571189024334066553871524351766213216834728798090854352",
            BigDecimal.PI - BigDecimal.TEN)
        assertReprEquals("2.641592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648",
            BigDecimal.PI - BigDecimal.ONE_HALF)
        assertReprEquals("3.041592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648",
            BigDecimal.PI - BigDecimal.ONE_TENTH)

        assertReprEquals("2.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264",
            BigDecimal.E - BigDecimal.ZERO)
        assertReprEquals("1.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264",
            BigDecimal.E - BigDecimal.ONE)
        assertReprEquals("0.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264",
            BigDecimal.E - BigDecimal.TWO)
        assertReprEquals("-7.281718171540954764639712528647337502242752906300040425033032372275923369646452405428617821474833572572533608067996940078182586403370956427099665704739404369261867671372056509236766170119246804748980988426165812069297845910850065115832490755238539331917736",
            BigDecimal.E - BigDecimal.TEN)
        assertReprEquals("2.218281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264",
            BigDecimal.E - BigDecimal.ONE_HALF)
        assertReprEquals("2.618281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264",
            BigDecimal.E - BigDecimal.ONE_TENTH)

        assertReprEquals("-0.9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999951",
            BigDecimal.of(Double.MIN_VALUE) - BigDecimal.ONE)
    }

    @Test
    fun testDecimalParsing() {
        assertEquals(BigDecimal.ZERO, BigDecimal.of("0.0"))
        assertEquals(BigDecimal.ONE, BigDecimal.of("1.0"))
        assertEquals(BigDecimal.TWO, BigDecimal.of("2.0"))
        assertEquals(BigDecimal.TEN, BigDecimal.of("10.0"))
        assertEquals(BigDecimal.ONE_HALF, BigDecimal.of("0.5"))
        assertEquals(BigDecimal.ONE_TENTH, BigDecimal.of("0.1"))
        assertEquals(-BigDecimal.ONE, BigDecimal.of("-1.0"))
        assertEquals(-BigDecimal.TWO, BigDecimal.of("-2.0"))
        assertEquals(-BigDecimal.TEN, BigDecimal.of("-10.0"))
        assertEquals(-BigDecimal.ONE_HALF, BigDecimal.of("-0.5"))
        assertEquals(-BigDecimal.ONE_TENTH, BigDecimal.of("-0.1"))

        assertEquals(BigDecimal.PI, BigDecimal.of("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648"))
        assertEquals(-BigDecimal.PI, BigDecimal.of("-3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648"))
        assertEquals(BigDecimal.E, BigDecimal.of("2.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264"))
        assertEquals(-BigDecimal.E, BigDecimal.of("-2.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264"))

        assertEquals(BigDecimal.of(1, 1000), BigDecimal.of("0." + (0 until 999).map { "0" }.joinToString("") +  "1"))
    }

    @Test
    fun testSqrt() {
        assertEquals(BigDecimal.ZERO, BigDecimal.ZERO.sqrt())
        assertEquals(BigDecimal.ONE, BigDecimal.ONE.sqrt())
        assertEquals(BigDecimal.of(2), BigDecimal.of(4).sqrt())
        assertEquals(BigDecimal.of(1.1), BigDecimal.of(1.21).sqrt())
    }

}