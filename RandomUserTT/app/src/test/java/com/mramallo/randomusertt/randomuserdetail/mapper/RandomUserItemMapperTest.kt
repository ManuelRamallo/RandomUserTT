package com.mramallo.randomusertt.randomuserdetail.mapper

import com.mramallo.randomusertt.core.data.dto.RandomUserDto
import com.mramallo.randomusertt.core.data.dto.RandomUserItemDto
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUser
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUserItem
import com.mramallo.randomusertt.ui.randomUserDetail.domain.mapper.toRandomUser
import com.mramallo.randomusertt.ui.randomUserDetail.domain.mapper.toRandomUserItem
import org.junit.Test

fun sampleRandomUserDto() = RandomUserDto(
    data = RandomUserItemDto(
        id = "1",
        email = "email",
        firstName = "firstName",
        lastName = "lastName",
        avatar = "avatar"
    )
)

fun sampleRandomUserItemDto() = RandomUserItemDto(
    id = "1",
    email = "email",
    firstName = "firstName",
    lastName = "lastName",
    avatar = "avatar"
)

class RandomUserItemMapperTest {


    @Test
    fun `toRandomUser When normal input return mapped item`() {
        val result = RandomUser.getMock()
        val expectedResult = sampleRandomUserDto().toRandomUser()

        assert(result.data == expectedResult.data)
    }

    @Test
    fun `toRandomUserItem When normal input return mapped item`() {
        val result = RandomUserItem.getMock()
        val expectedResult = sampleRandomUserItemDto().toRandomUserItem()

        assert(result.id == expectedResult.id)
        assert(result.email == expectedResult.email)
        assert(result.firstName == expectedResult.firstName)
        assert(result.lastName == expectedResult.lastName)
        assert(result.avatar == expectedResult.avatar)
    }

}