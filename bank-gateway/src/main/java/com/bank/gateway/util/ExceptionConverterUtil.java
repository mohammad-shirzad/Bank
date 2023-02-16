package com.bank.gateway.util;

import com.bank.api.dto.exception.*;
import com.bank.domain.data.exception.*;

import javax.validation.constraints.NotNull;

public class ExceptionConverterUtil {
    public static void throwBusinessExceptionDto(@NotNull BusinessException e) throws BusinessExceptionDto {
        throw new BusinessExceptionDto(e.getClass().getSimpleName(), "desc");
    }

    public static void throwDtoException(BusinessException e) throws EntityAlreadyExistsExceptionDto, HolderExceptionDto, PaymentApplicationTypeNotSupportCardWithoutHolderExceptionDto, EntityNotExistsExceptionDto {
        try {
            throw e;
        } catch (EntityAlreadyExistsException ex) {
            throw new EntityAlreadyExistsExceptionDto();
        } catch (EntityNotExistsException ex) {
            throw new EntityNotExistsExceptionDto();
        } catch (HolderException ex) {
            throw new HolderExceptionDto();
        } catch (PaymentApplicationTypeNotSupportCardWithoutHolderException ex) {
            throw new PaymentApplicationTypeNotSupportCardWithoutHolderExceptionDto();
        } catch (BusinessException ex) {
            throw new BusinessRuntimeExceptionDto();
        }
    }
}
