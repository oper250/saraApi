package com.jk.saraApi.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
@Scope( value = "singleton" )
public class ImageUtil {

	@Value("${img.max.size}")
	private long imgMaxSize;

	@Value("${img.bucket.upload.base.path}")
	private String bucketUploadBasePath;

	@Value("${img.bucket.base.url}")
	private String bucketBaseUrl;

	private final String BUCKET_REP_SUFFIX = "/rep";
	private final String BUCKET_STORY_SUFFIX = "/story";

	/**
	 * 버킷 대표 이미지 파일 업로드
	 *
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public String uplaodBucketRepImage(MultipartFile file) throws Exception {
		if( file.getSize() > imgMaxSize ) {
			throw new CommonException( "1001", "업로드 파일의 용량이 초과되었습니다. [Max 10Mb]" );
		}
		String uploadFileName = file.getOriginalFilename();
		if( CommonUtil.isEmpty( uploadFileName ) ) {
			throw new CommonException( "1002", "첨부한 파일의 파일명이 존재하지 않습니다." );
		}

		String uploadFileFormat = uploadFileName.substring( uploadFileName.lastIndexOf(".") +1 );

		// 파일 확장자 검증
		if( !CommonUtil.isAcceptedUploadFileFormat( uploadFileFormat ) ) {
			throw new CommonException( "1002", "[" + uploadFileFormat + "] 형식의 파일은 업로드 할 수 없습니다." );
		}

		System.out.println("!!!!!!!!!!!!!" + uploadFileName);

		String monthSuffix = CommonUtil.SEPARATOR + CommonUtil.getServerTime( "%Y%m" );
		String saveDir = this.bucketUploadBasePath + this.BUCKET_REP_SUFFIX + monthSuffix;
		System.out.println("@@@@@" + saveDir);
		String saveFileName = CommonUtil.SEPARATOR + CommonUtil.getRandomString( -1, 8 ) + CommonUtil.getServerTime( "%Y%m%d" ) + CommonUtil.getRandomString( -1, 8 ) + "." + uploadFileFormat;
		System.out.println("@@@@@@@@@@@@@@" + saveFileName);
		File aa = new File("/test");
		aa.mkdir();
		CommonUtil.makeDirs( "/aaa" );
		System.out.println("^^^^^^^^^^^;;" + "통과1");
		CommonUtil.makeDirs( saveDir );
		System.out.println("^^^^^^^^^^^;;" + "통과2");
		System.out.println("!!!!!경로::" + this.bucketBaseUrl + CommonUtil.SEPARATOR + saveFileName);
/*
		file.transferTo( new File( saveDir + saveFileName ) );*/

		return this.bucketBaseUrl + saveDir + saveFileName;
	}

	/**
	 * 버킷 스토리 이미지 파일 업로드
	 *
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public String uplaodBucketStoryImage( MultipartFile file ) throws Exception {
		if( file.getSize() > imgMaxSize ) {
			throw new CommonException( "1001", "업로드 파일의 용량이 초과되었습니다. [Max 10Mb]" );
		}
		String uploadFileName = file.getOriginalFilename();
		if( CommonUtil.isEmpty( uploadFileName ) ) {
			throw new CommonException( "1002", "첨부한 파일의 파일명이 존재하지 않습니다." );
		}

		String uploadFileFormat = uploadFileName.substring( uploadFileName.lastIndexOf(".") +1 );

		// 파일 확장자 검증
		if( !CommonUtil.isAcceptedUploadFileFormat( uploadFileFormat ) ) {
			throw new CommonException( "1002", "[" + uploadFileFormat + "] 형식의 파일은 업로드 할 수 없습니다." );
		}

		String monthSuffix = CommonUtil.SEPARATOR + CommonUtil.getServerTime( "%Y%m" );
		String saveDir = this.bucketUploadBasePath + this.BUCKET_STORY_SUFFIX + monthSuffix;
		String saveFileName = CommonUtil.SEPARATOR + CommonUtil.getRandomString( -1, 8 ) + CommonUtil.getServerTime( "%Y%m%d" ) + CommonUtil.getRandomString( -1, 8 ) + "." + uploadFileFormat;

		CommonUtil.makeDirs( saveDir );

		file.transferTo( new File( saveDir + saveFileName ) );

		return this.bucketBaseUrl + this.BUCKET_STORY_SUFFIX + monthSuffix + saveFileName;
	}
}
